package action;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAction() {
	}

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

	public String mylogin() {
		System.out.println(username + "" + password);
		if (username.equals(password)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String execute() {
		if (user.getUsername().equals(user.getPassword())) {
			return "success";
		} else {
			return "error";
		}
	}
}
