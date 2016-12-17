package com.bean;

public class User {
	private String name;// 用户姓名
	private Integer age;// 年龄
	private String sex;// 性别

	public User() {
	}

	// 构造方法
	public User(String name, Integer age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	//
	// // 输出javabean的属性值方法
	// public void printInfo() {
	// System.out.println("用户姓名--" + name);
	// System.out.println("用户年龄--" + age);
	// System.out.println("用户姓别--" + sex);
	// }
}
