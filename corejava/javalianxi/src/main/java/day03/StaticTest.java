package day03;

public class StaticTest {
	// 静态成员变量，int型的a
	static int a;

	// 静态方法
	static void testMethod() {
		System.out.println("test method...");
	}

	// 静态代码块
	static {
		System.out.println("execute static codes...");
	}

	public static void main(String[] args) {
		// 打印静态成员变量
		System.out.println(a);
		// 通过对象来访问静态方法
		StaticTest obj = new StaticTest();
		StaticTest.testMethod();
		obj.testMethod();
	}
}
