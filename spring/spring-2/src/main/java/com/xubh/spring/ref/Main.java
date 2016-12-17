package com.xubh.spring.ref;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		//1. 创建 IOC 容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");

		UserAction userAction = (UserAction) ctx.getBean("userAction");
		userAction.execute();
	}

}
