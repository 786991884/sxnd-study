package bean;

import java.util.Date;

public class Student {
	private String name;
	private Date birthday;
	private String phone;

	public Student() {
	}

	public Student(String name, Date birthday, String phone) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
