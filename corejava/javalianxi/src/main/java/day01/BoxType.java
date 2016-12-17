package day01;

import java.util.ArrayList;
import java.util.List;

public class BoxType {
	public static void main(String[] args) {
		int i = 10;
		// 用valueof方法把i转成Integer变量
		Integer itg = Integer.valueOf(i);
		itg = new Integer(i);// 构造方法创建
		List list = new ArrayList();
		list.add(itg);
		// 把包装类转换成基本类型
		Integer integer = Integer.valueOf(100);
		integer.intValue();
		System.out.println(integer);
		Double d = Double.valueOf(98.5);
		d.doubleValue();
		System.out.println(d);
	}
}
