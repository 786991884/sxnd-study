package com.oraclewdp.struts2.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.struts2.entity.User;

public class CollectionAction extends ActionSupport {
	//该接口如果没有显式实例化，那么默认是java.util.ArrayList
	private Collection<User> userList;

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}


}
