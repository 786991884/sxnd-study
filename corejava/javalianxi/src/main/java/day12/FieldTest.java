package day12;

import java.lang.reflect.Field;

//测试类
class FieldTestClass {
	String name;
	int age;

	public FieldTestClass(String name, int age) {
		this.name = name;
		this.age = age;
	}

}

public class FieldTest {
	public static void main(String[] args) {
		FieldTestClass obj1 = new FieldTestClass("hello", 100);
		FieldTestClass obj2 = new FieldTestClass("hello2", 300);
		System.out.println(compare(obj1, obj2));
	}

	private static FieldTestClass compare(FieldTestClass obj1,
										  FieldTestClass obj2) {
		// 以下用两种方式获取一个Field对象
		try {
			Field field = obj1.getClass().getDeclaredField("age");
			field = FieldTestClass.class.getDeclaredField("age");
			// 创建两个对象的age的值
			int val1 = (Integer) field.get(obj1);
			int val2 = field.getInt(obj2);
			// 进行比较
			if (val1 > val2) {
				return obj1;
			} else {
				return obj2;
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;

	}
}
