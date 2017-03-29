package com.xubh01.cycletimer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * http://mp.weixin.qq.com/s/mvFwjgxliwx808Hn_9ruEA
 * 时间轮算法简单实现(环形队列法)
 * 业务有定时任务或者定时超时的需求，当任务量很大时，可能需要维护大量的timer，或者进行低效的扫描
 * 例如：58到家APP实时消息通道系统，对每个用户会维护一个APP到服务器的TCP连接，用来实时收发消息，对这个TCP连接，
 * 有这样一个需求：“如果连续30s没有请求包（例如登录，消息，keepalive包），服务端就要将这个用户的状态置为离线”
 *
 * @author xubh
 * @date 2017-03-28
 * @modify
 * @copyright
 */

public class HashWheelTimer {
    private final static Logger logger = LoggerFactory.getLogger(HashWheelTimer.class);
    //记录总共经过了多少时间
    private static AtomicLong atomicLong = new AtomicLong(0);
    //时间轮一圈时长 s
    private static final int size = 10;
    //1）30s超时，就创建一个index从0到30的环形队列（本质是个数组）
    private static Set[] uidArr = new Set[size];
    //3）同时还有一个Map<uid, index>，记录uid落在环上的哪个slot里
    private static Map<String, Integer> map = new ConcurrentHashMap<>();
    //同时：1）启动一个timer，每隔1s，在上述环形队列中移动一格，0->1->2->3…->29->30->0…  2）有一个Current Index指针来标识刚检测过的slot
    private ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
    private Object lock = new Object();

    public HashWheelTimer() {
        for (int i = 0; i < size; i++) {
            //Set set = new HashSet();
            Set set = Collections.synchronizedSet(new HashSet<>());
            //2）环上每一个slot是一个Set<uid>，任务集合
            uidArr[i] = set;
        }
        pool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                int curIndex = (int) (atomicLong.getAndIncrement() % size);
                synchronized (lock) {
                    // logger.info("curIndex:{},ele:{}", curIndex, uidArr[curIndex]);
                    Set s = uidArr[curIndex];
                    if (s != null && !s.isEmpty()) {
                        logger.info("slot index {} , all time out:{}", curIndex, s);
                        s.clear();
                    }

                }

            }
        }, 0, 1, TimeUnit.SECONDS);

    }

    /**
     * 当有某用户uid有请求包到达时：
     * 1）从Map结构中，查找出这个uid存储在哪一个slot里
     * 2）从这个slot的Set结构中，删除这个uid
     * 3）将uid重新加入到新的slot中，具体是哪一个slot呢 => Current Index指针所指向的上一个slot，因为这个slot，会被timer在30s之后扫描到
     * 4）更新Map，这个uid对应slot的index值
     *
     * @param uid
     */
    public void putMessage(String uid) {
        Integer slot = map.get(uid);
        if (slot == null) {
            slot = uid.hashCode() % size;
            map.put(uid, slot);
            logger.info("map store uid:{},slot :{}", uid, slot);
        }
        synchronized (lock) {
            Set s = uidArr[slot];
            if (s.contains(uid)) {
                s.remove(uid);
            }
            int lastSlot = (int) ((atomicLong.get() - 1) % size);
            uidArr[lastSlot].add(uid);
            map.put(uid, lastSlot);
            logger.info("map put uid:{},lastSlot:{}", uid, lastSlot);
        }
    }

    /**
     * 哪些元素会被超时掉呢？
     * Current Index每秒种移动一个slot，这个slot对应的Set<uid>中所有uid都应该被集体超时！
     * 如果最近30s有请求包来到，一定被放到Current Index的前一个slot了，Current Index所在的slot对应Set中所有元素，都是最近30s没有请求包来到的。
     * <p>
     * 所以，当没有超时时，Current Index扫到的每一个slot的Set中应该都没有元素。
     * <p>
     * 优势：
     * （1）只需要1个timer
     * （2）timer每1s只需要一次触发，消耗CPU很低
     * （3）批量超时，Current Index扫到的slot，Set中所有元素都应该被超时掉
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        HashWheelTimer wheelTimer = new HashWheelTimer();
        Thread.sleep(3000);
        wheelTimer.putMessage("u123");
        wheelTimer.putMessage("u456");
        wheelTimer.putMessage("u789");
        Thread.sleep(2000);
        wheelTimer.putMessage("u123");

    }
}