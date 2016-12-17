package day12;

import java.lang.reflect.Constructor;

class Student {
	private String name;
	private int age;

	// 无参数的构造方法
	public Student() {
		super();
	}

	// 带参数的构造方法
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 覆盖toString()方法
	@Override
	public String toString() {
		return "stu:" + name + "," + age;
	}
}

public class NewInstanceTest {
	public static void main(String[] args) throws Exception {
		// 使用无参数的构造方法
		Class<Student> clazz = Student.class;// 获取class对象
		Student obj = clazz.newInstance();// 调用newInstance()方法
		System.out.println(obj);// 检验一下是否创建成功
		// 使用带参数的构造方法
		Constructor<Student> con = clazz
				.getConstructor(String.class, int.class);
		// 用构造器创建对象
		obj = con.newInstance("张三", 30);
		System.out.println(obj);// 打印学生信息
	}
}
