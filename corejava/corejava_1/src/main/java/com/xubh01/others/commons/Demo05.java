package com.xubh01.others.commons;


import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

import java.util.Queue;

/**
 * Queue队列
 * 1、循环队列:CircularFifoQueue
 * 2、只读队列:不可改变队列  UnmodifiableQueue
 * 3、断言队列:PredicatedQueue.predicatedQueue()
 */
public class Demo05 {

    public static void main(String[] args) {
        circular();
        //readOnly();
        //predicate();
    }

    /**
     * 断言队列
     */
    public static void predicate() {
        //循环队列
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        Predicate notNull = NotNullPredicate.INSTANCE;
        //包装成对应的队列
        Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
        que2.add(null);
    }

    /**
     * 只读队列
     */
    public static void readOnly() {
        //循环队列
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
        readOnlyQue.add("d");
    }

    /**
     * 循环队列
     */
    public static void circular() {
        //循环队列
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        //查看
        for (int i = 0; i < que.size(); i++) {
            System.out.println(que.get(i));
        }

    }

}
