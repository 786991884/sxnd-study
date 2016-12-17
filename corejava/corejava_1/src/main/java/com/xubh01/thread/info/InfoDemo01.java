package com.xubh01.thread.info;

/**
 * Thread.currentThread()	 :当前线程
 * setName():设置名称
 * getName():获取名称
 * isAlive():判断状态
 */
public class InfoDemo01 {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread it = new MyThread();
        Thread proxy = new Thread(it, "挨踢");
        proxy.setName("test");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName()); //main

        proxy.start();
        System.out.println("启动后的状态:" + proxy.isAlive());
        Thread.sleep(200);
        it.stop();
        Thread.sleep(100);
        System.out.println("停止后的状态:" + proxy.isAlive());
    }

}
