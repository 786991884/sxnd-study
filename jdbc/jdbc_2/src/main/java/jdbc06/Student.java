package jdbc06;

/*
 * 实体类，对应数据库中student表，用来封装student表中的数据。
 */

public class Student {
	private int id;
	private String name;
	private int age;

	public Student() {
		this.id = 0;
		this.name = "";
		this.age = 0;
	}

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
