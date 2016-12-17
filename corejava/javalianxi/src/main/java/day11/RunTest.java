package day11;

//实现Runnable接口的线程类
public class RunTest implements Runnable {

	@Override
	public void run() {// run方法
		System.out.println("thread running...");
	}
}

// 继承自Thread类的线程类
class ThreadTest extends Thread {
	@Override
	public void run() {
		System.out.println("thread running...");
	}
}