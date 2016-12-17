package com.xbh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintUserInfo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");// 装载配置文件
		UserInfo ui = (UserInfo) context.getBean("user1");
		ui.printInfo();// 执行bean的打印方法
	}
}
