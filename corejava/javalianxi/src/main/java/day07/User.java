package day07;

import java.util.Comparator;

//可比较的用户类
public class User {
	private String id;// 主键
	private int age;// 年龄

	// 构造方法

	public User(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 测试方法
	public static void main(String[] args) {
		// 创建两个用户对象
		User u1 = new User("u1001", 25);
		User u2 = new User("u1002", 20);
		Comparator comp = new UserComparator();
		int rst = comp.compare(u1, u2);
		if (rst > 0) {
			System.out.println("用户1大于用户2");
		} else if (rst < 0) {
			System.out.println("用户1小于用户2");
		} else {
			System.out.println("用户1等于用户2");

		}
	}
}

// 比较器类
class UserComparator implements Comparator {

	@Override
	// 比较方法
	public int compare(Object o1, Object o2) {
		User u1 = (User) o1;
		User u2 = (User) o2;
		return u1.getAge() - u2.getAge();
	}

}