package com.oraclewdp.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.entity.User;

public class MapAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Map<String, User> userMap;
	public Map<String, User> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}

	
}
