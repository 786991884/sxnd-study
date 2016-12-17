package day11;

//实现Runnable接口
public class MyThread implements Runnable {
	int index = 0;// index变量

	@Override
	public void run() {

	}

}

class MyThread1 {
	int index = 0;// index变量

	// 定义一个内部类，继承Thread

	private class InnerClass extends Thread {
		@Override
		public void run() {
		}
	}

	// 这个函数的作用是返回InnerClass的一个匿名对象
	Thread getThread() {
		return new InnerClass();
	}
}
