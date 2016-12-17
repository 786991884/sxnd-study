package action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction4_3 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String repassword;
	private Date birthday;
	private int age;

	public String login() {
		return ActionSupport.SUCCESS;
	}

	// public void validateLogin() {
	// if (this.username == null || "".equals(this.username)) {
	// this.addFieldError("username", "用户名不能为空！");
	// }
	// if (this.password == null || "".equals(this.password)) {
	// this.addFieldError("password", "密码不能为空！");
	// } else if (this.password.length() < 6) {
	// this.addFieldError("password", "密码不能小于六位！");
	// }
	// }
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
