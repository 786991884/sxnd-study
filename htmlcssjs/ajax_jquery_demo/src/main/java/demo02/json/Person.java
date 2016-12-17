package demo02.json;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 6430358025223336482L;
	private String name;
	private String sex;
	private int age;

	public Person() {
	}

	public Person(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "age=" + age + "  name=" + name + "  sex=" + sex;
	}
}
