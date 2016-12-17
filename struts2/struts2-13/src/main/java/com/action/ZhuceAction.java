package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class ZhuceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;
	private String rpass;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
