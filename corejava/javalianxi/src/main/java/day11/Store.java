package day11;

//仓库类
public class Store {
	private final int MAX_SIZE;// 仓库的最大容量
	private int count;// 当前的货物数量

	// 初始化最大容量的构造方法

	public Store(int n) {
		MAX_SIZE = n;
		count = 0;
	}

	// 往仓库加货物的方法
	public synchronized void add() {
		// 每次执行都判断仓库是否已满
		while (count >= MAX_SIZE) {
			System.out.println("已经满了");
			try {
				// 如果满了，就进入等待池
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;// 数量加1
		// 打印当前仓库货物数量
		System.out.println(Thread.currentThread().toString() + " put " + count);
		// 仓库中已经有东西可以取了，则通知所有的消费者线程来拿
		this.notifyAll();
	}

	// 从仓库拿走货物的方法
	public synchronized void remove() {
		while (count <= 0) {// 每次执行都判断仓库是否为空
			System.out.println("空了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}// 如果为空，就进入等待池
		}
		// 打印当前仓库的货物数量
		System.out.println(Thread.currentThread().toString() + " get " + count);
		count--;// 数量减1
		// 仓库还没装潢，通知生产者添加货物
		this.notify();
	}

	public static void main(String[] args) {
		Store s = new Store(5);// 创建容量为5的仓库
		// 创建两个生产者和两个消费者
		Thread pro = new Producer(s);
		Thread con = new Consumer(s);
		Thread pro2 = new Producer(s);
		Thread con2 = new Consumer(s);
		pro.setName("producer");
		con.setName("consumer");
		pro2.setName("producer2");
		con2.setName("consumer2");
		// 启动各个线程
		pro.start();
		pro2.start();
		con.start();
		con2.start();
	}
}

// 生产者线程类
class Producer extends Thread {
	private Store s;

	public Producer(Store s) {
		this.s = s;
	}

	@Override
	// 线程方法
	public void run() {
		while (true) {// 永真循环
			s.add();// 往仓库加货物
			try {
				// 为了更直观，休息1秒钟
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 消费者线程类
class Consumer extends Thread {
	private Store s;

	public Consumer(Store s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			s.remove();// 从仓库取走货物
			try {
				// 为更直观，休息1.5秒钟
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
