package day11;

class MyThread2 extends Thread {
	public static int index;// 静态变量index

	@Override
	public void run() {
		// 循环打印index加1以后的值
		for (int i = 1; i < 100; i++) {
			System.out.println(getName() + ":" + index++);
		}
	}
}

class MyThread3 extends Thread {
	public static int index;// 静态变量index
	public static Object obj = new Object();// 用任意一个对象来加锁

	@Override
	public void run() {
		// 为冲突加上同步代码块
		synchronized (obj) {
			for (int i = 0; i < 100; i++) {
				System.out.println(getName() + ":" + index++);
			}
		}
	}
}

public class SyncTest {
	public static void main(String[] args) {
		// 启动三个线程
		new MyThread3().start();
		new MyThread3().start();
		new MyThread3().start();
	}
}
