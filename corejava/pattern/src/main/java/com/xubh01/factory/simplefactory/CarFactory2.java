package com.xubh01.factory.simplefactory;

/**
 * 简单工厂类
 * @author 上学堂高淇 www.sxt.cn
 *
 */
public class CarFactory2 {
	
	public static  Car createAudi(){
		return new Audi();
	}
	public static  Car createByd(){
		return new Byd();
	}
	
}
