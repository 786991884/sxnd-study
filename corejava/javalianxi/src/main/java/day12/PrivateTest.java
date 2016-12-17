package day12;

import java.lang.reflect.Field;

class PrivateTestClass {
	private String field1;// 私有属性

	// 构造方法
	public PrivateTestClass(String field1) {
		super();
		this.field1 = field1;
	}
}

public class PrivateTest {
	public static void main(String[] args) throws Exception, SecurityException {
		PrivateTestClass obj = new PrivateTestClass("hello");
		Class clazz = obj.getClass();// 获取Class对象
		Field f = clazz.getDeclaredField("field1");// 获取field1对象
		f.setAccessible(true);// 把它的可访问属性设置为true
		System.out.println(f.get(obj));
	}
}
