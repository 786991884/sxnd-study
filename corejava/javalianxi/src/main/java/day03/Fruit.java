package day03;

abstract class Fruit {// 水果类
	double weight;// 重量
	double volume;// 体积

	abstract String getTaste();// 味道
}

interface Packable {// 可包装接口
	void pack();
}

interface Divisible {// 可分辨接口
	void divisible();
}

class Apple extends Fruit implements Packable {
	@Override
	public void pack() {
		System.out.println("包装苹果");
	}

	@Override
		// 实现getTaste方法
	String getTaste() {
		return "甜";
	}
}

class Orange extends Fruit implements Packable, Divisible {

	@Override
	public void divisible() {
		System.out.println("把橙子分辨");
	}

	@Override
	public void pack() {
		System.out.println("包装橙子");
	}

	@Override
	String getTaste() {
		return "酸";
	}

}