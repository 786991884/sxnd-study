package bean;

import java.util.Date;

public class StudentBean {
	private String name;
	private Date birthday;
	private String phone;
	private String email;
	private String hopeJob;

	public StudentBean() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHopeJob() {
		return hopeJob;
	}

	public void setHopeJob(String hopeJob) {
		this.hopeJob = hopeJob;
	}
}
