package day03;

class Base {// 父类
	int a;// 成员变量a

	Base(int a) {// 有参的构造方法
		this.a = a;
	}
}

class Child extends Base {// 子类
	Child() {// 无参的构造方法
		super(100);// 为父类传入一个100的参数
	}

	Child(int a) {// 有参的构造方法
		super(a);// 为父类传入一个a参数
	}
}

public class Test {
	public static void main(String[] args) {
		new Child();// 调用无参的构造方法
		new Child(200);// 调用有参的构造方法
	}
}
