package com.oraclewdp.struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.struts2.entity.User;

public class ListAction extends ActionSupport {
	//没有显式就是ArrayList
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
