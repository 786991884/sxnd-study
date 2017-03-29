package com.xubh01.cycletimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * http://mp.weixin.qq.com/s/mvFwjgxliwx808Hn_9ruEA
 * @author xubh
 * @date 2017-03-24
 * @modify
 * @copyright
 */
public class Temp {
    public static void main(String[] args) throws Exception {
        //创建Timer, 精度为100毫秒,
        HashedWheelTimer timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS, 16);

        System.out.println(LocalTime.now());

        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(LocalTime.now());
                System.out.println(timeout);
            }
        }, 5, TimeUnit.SECONDS);

        //阻塞main线程
        System.in.read();
    }

    @Test
    public void test1() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        System.out.println("start:" + LocalDateTime.now().format(formatter));
        hashedWheelTimer.newTimeout(timeout -> {
            System.out.println("task :" + LocalDateTime.now().format(formatter));
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    /**
     * 可以看到，当前一个任务执行时间过长的时候，会影响后续任务的到期执行时间的。
     * 也就是说其中的任务是串行执行的。所以，要求里面的任务都要短平快。
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        System.out.println("start:" + LocalDateTime.now().format(formatter));
        hashedWheelTimer.newTimeout(timeout -> {
            Thread.sleep(3000);
            System.out.println("task1:" + LocalDateTime.now().format(formatter));
        }, 3, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(timeout -> System.out.println("task2:" + LocalDateTime.now().format(
                formatter)), 4, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}
