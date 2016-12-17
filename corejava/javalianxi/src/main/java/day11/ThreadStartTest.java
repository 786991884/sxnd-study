package day11;

public class ThreadStartTest {
	public static void main(String[] args) {
		// 创建一个线程实例
		ThreadTest1 t1 = new ThreadTest1();
		Thread t3 = new ThreadTest1();
		Thread t2 = new Thread(new RunnableTest());
		// 启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadTest1 extends Thread {
	@Override
	public void run() {
	}
}

class RunnableTest implements Runnable {

	@Override
	public void run() {

	}

}