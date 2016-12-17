package day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//学生类，实现Serializable接口
class Student implements Serializable {
	// 序列化ID
	private static final long serialVersionUID = 1L;
	private String name;// 学生姓名
	private int age;// 年龄

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class SerialTest {
	public static void main(String[] args) throws IOException, Exception {
		Student stu = new Student();// 创建一个学生对象
		stu.setAge(20);// 设置年龄为20
		stu.setName("张三");
		// 创建一个对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"d:/test/obj.dat"));
		// 把对象写入输出流
		oos.writeObject(stu);
		oos.close();// 关闭流
		// 创建一个对象输入流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"d:/test/obj.dat"));
		Object obj = ois.readObject();// 读出已经序列化的对象
		Student stuBak = (Student) obj;// 进行类型转换
		// 打印数据在控制台，检查序列化和反序列化是否成功
		System.out.println("stu name is:" + stuBak.getName());
		System.out.println("stu age is:" + stuBak.getAge());
	}
}
