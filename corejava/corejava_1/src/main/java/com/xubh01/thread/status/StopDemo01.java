package com.xubh01.thread.status;

public class StopDemo01 {


}

//class Study implements Runnable {
class Study extends Thread {
    //1)、线程类中 定义 线程体使用的标识
    private boolean flag = true;

    static int i;

    @Override
    public void run() {
        //2)、线程体使用该标识
        while (flag) {
            System.out.println("study thread...." + i++);
        }
        System.out.println("线程停止了");
    }

    //3)、对外提供方法改变标识
    public void setRunning() {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Study s = new Study();
        //new Thread(s).start();
        s.start();
        Thread.sleep(1000);
        //外部干涉
        s.setRunning();
        /*for (int i = 0; i < 100; i++) {
            if (50 == i) { //外部干涉
                s.setRunning();
            }
            System.out.println("main.....-->" + i);
        }*/
    }

}
