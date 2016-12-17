package com.xubh02.oop.testStatic;

public class Student {
	String name;
	int id;

	static  int  ss;

	public static void printSS(){
		System.out.println(ss);
	}


	public void study(){
		printSS();
		System.out.println(name+"在學習");
	}

	public void sayHello(String sname){
		System.out.println(name+"向"+sname+"說：你好！");
	}

}



