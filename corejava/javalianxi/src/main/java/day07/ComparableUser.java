package day07;

//可比较的用户类
public class ComparableUser implements Comparable {
	private String id;// 主键
	private int age;// 年龄
	// 构造方法

	public ComparableUser(String id, int age) {
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

	@Override
	// 比较方法
	public int compareTo(Object o) {
		// 用年龄进行比较
		return this.age - ((ComparableUser) o).getAge();
	}

	// 测试方法
	public static void main(String[] args) {
		// 创建两个用户对象
		ComparableUser user1 = new ComparableUser("u1001", 25);
		ComparableUser user2 = new ComparableUser("u1002", 20);
		if (user1.compareTo(user2) > 0) {
			System.out.println("用户1大于用户2");
		} else if (user1.compareTo(user2) < 0) {
			System.out.println("用户1小于用户2");
		} else {
			System.out.println("用户1等于用户2");
		}
	}
}
