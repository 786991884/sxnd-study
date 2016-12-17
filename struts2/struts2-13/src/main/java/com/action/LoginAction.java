package com.action;

import javax.xml.ws.Action;

import com.opensymphony.xwork2.ActionSupport;

//@Results({ @Result(name = "success", location = "/success.jsp"),
//		@Result(name = "error", location = "/error.jsp"),
//		@Result(name = "exit", location = "/index.jsp") })
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

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

	@Override
	@Action()
	public String execute() throws Exception {
		if (username.equals("xbh") && password.equals("1234")) {
			return "success";
		} else {
			return "error";
		}
	}

	@Action() 
	public String exit() {
		return "exit";
	}
}
