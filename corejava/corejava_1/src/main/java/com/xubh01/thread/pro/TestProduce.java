package com.xubh01.thread.pro;

public class TestProduce {
    public static void main(String[] args) {
        SyncStack sStack = new SyncStack();
        Shengchan sc = new Shengchan(sStack);
        Xiaofei xf = new Xiaofei(sStack);
        sc.start();
        xf.start();
    }
}

class Mantou {
    int id;

    Mantou(int id) {
        this.id = id;
    }
}

class SyncStack {
    int index = 0;
    Mantou[] ms = new Mantou[10];

    public synchronized void push(Mantou m) {
        while (index == ms.length) {
            try {
                this.wait();
                //wait后，线程会将持有的锁释放。sleep是即使睡着也持有互斥锁。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify(); //唤醒在当前对象等待池中等待的第一个线程。notifyAll叫醒所有在当前对象等待池中等待的所有线程。
        //如果不唤醒的话。以后这两个线程都会进入等待线程，没有人唤醒。
        ms[index] = m;
        index++;
    }

    public synchronized Mantou pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return ms[index];
    }
}

class Shengchan extends Thread {
    SyncStack ss = null;

    public Shengchan(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("造馒头：" + i);
            Mantou m = new Mantou(i);
            ss.push(m);
        }
    }
}

class Xiaofei extends Thread {
    SyncStack ss = null;

    public Xiaofei(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Mantou m = ss.pop();
            System.out.println("吃馒头：" + i);

        }
    }
}
