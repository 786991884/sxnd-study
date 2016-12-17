package com.xbh;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public User user;
	public String name;
	public String password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
