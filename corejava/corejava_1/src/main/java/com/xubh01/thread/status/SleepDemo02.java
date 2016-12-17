package com.xubh01.thread.status;

/**
 * Sleep模拟 网络延时  线程不安全的类
 */
public class SleepDemo02 {

    public static void main(String[] args) {
        //真实角色
        Web12306 web = new Web12306();
        Web12306 web2 = new Web12306();
        //代理
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛已");
        Thread t3 = new Thread(web, "攻城师");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }

}

class Web12306 implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break; //跳出循环
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }


}
