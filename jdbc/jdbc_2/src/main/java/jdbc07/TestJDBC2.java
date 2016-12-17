package jdbc07;

import java.util.Random;

/*
 * 不使用ThreadLocal的情况下
 */
public class TestJDBC2 implements Runnable {
	// 创建线程局部变量personLocal，用来保存Person对象。
	// private final static ThreadLocal<Person> personLocal = new
	// ThreadLocal<Person>();
	private static Person person = null;

	public static void main(String[] args) {
		TestJDBC2 tj = new TestJDBC2();
		Thread t1 = new Thread(tj, "a");
		Thread t2 = new Thread(tj, "b");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println("线程" + currentThreadName + "正在运行！");

			Random random = new Random();
			int age = random.nextInt(100);
			// System.out.println("线程" + currentThreadName + "设置年龄:" + age);
			// 从ThreadLocal对象获取一个Person对象，并将随机数年龄插入到对象属性中
			// Person person = personLocal.get();
			if (person == null) {
				System.out.println("线程" + currentThreadName + "设置年龄:" + age);
				person = new Person();
				person.setAge(age);
				// personLocal.set(person);
			}
			// System.out.println("线程" + currentThreadName + "第1次读年龄:" +
			// personLocal.get().getAge());
			System.out.println("线程" + currentThreadName + "第1次读年龄:"
					+ person.getAge());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println("线程" + currentThreadName + "第2次读年龄:" +
			// personLocal.get().getAge());
			System.out.println("线程" + currentThreadName + "第2次读年龄:"
					+ person.getAge());
		}
	}
}
