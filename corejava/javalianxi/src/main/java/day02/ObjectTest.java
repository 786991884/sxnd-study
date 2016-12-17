package day02;

class Dog {
	static int count;// 狗对象的创建数量
	int age;
	String name;

	public Dog() {
	}

	Dog(int age, String name) {
		this.age = age;
		this.name = name;
	}

	// 跑的方法
	void run() {
		System.out.println("running...");
	}
}

public class ObjectTest {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog(8, "乐乐");
		System.out.println(dog2.name);
		dog2.run();
	}
}
