package com.xubh01.thread.status;

/**
 * join:合并线程
 */
public class JoinDemo01 extends Thread {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JoinDemo01 demo = new JoinDemo01();
        Thread t = new Thread(demo); //新生
        t.start();//就绪
        //cpu调度 运行


        for (int i = 0; i < 1000; i++) {
            if (50 == i) {
                t.join(); //main阻塞...
            }
            System.out.println("main...." + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join...." + i);
        }
    }

}
