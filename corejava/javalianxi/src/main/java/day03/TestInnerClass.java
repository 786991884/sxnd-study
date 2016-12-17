package day03;

class Outter {// 定义外部类Outter
	static class Inner {// 定义静态内部类Inner

	}

	class Inner1 {// 定义成员内部类Inner1

	}

	public void abc() {// 成员方法
		class MyLocal {// 定义局部内部类

		}
		new OneInterface() {// 直接new一个方法
			public void interMethod() {// 接口方法

			}
		};
	}
}

public class TestInnerClass {
	public static void main(String[] args) {
		Outter o = new Outter();// 创建外部类实例
		Outter.Inner1 i = o.new Inner1();// 创建内部类实例
	}
}
