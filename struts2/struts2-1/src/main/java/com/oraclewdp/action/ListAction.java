package com.oraclewdp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.entity.User;

public class ListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
