package com.xubh02.oop.staticInitBlock;

public class TestStaticInitBlock extends Parent001 {

	static int a ;

	static {
		System.out.println("静态初始化TestStaticInitBlock!");
		a = 100;
	}


	public static void main(String[] args) {

	}
}
