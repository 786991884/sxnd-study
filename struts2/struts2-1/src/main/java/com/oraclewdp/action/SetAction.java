package com.oraclewdp.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.entity.User;

public class SetAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Set<User> userSet = new HashSet<>();

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
}
