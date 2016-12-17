package day12;

import java.lang.reflect.Field;

class DataObject {
	private String name;
	private String desc;
	private int age;
	private String other;

	public DataObject(String name, String desc, int age, String other) {
		super();
		this.name = name;
		this.desc = desc;
		this.age = age;
		this.other = other;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		// 得到所有的成员变量的fields
		Field[] fields = this.getClass().getDeclaredFields();
		// 遍历一下
		for (Field f : fields) {
			sb.append(f.getName());// 得到变量的名字
			sb.append("=");// 添加"="
			try {
				sb.append(f.get(this));// 得到变量的值
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			sb.append("\n");// 添加一个换行符
		}
		return sb.toString();// 返回结果
	}
}

public class DataObjectTest {
	public static void main(String[] args) {
		// 创建对象
		Object obj = new DataObject("张三", "desc test", 10, "other test");
		// 打印它的toString()方法的返回值
		System.out.println(obj);
	}
}
