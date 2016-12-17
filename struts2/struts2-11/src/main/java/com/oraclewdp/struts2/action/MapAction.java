package com.oraclewdp.struts2.action;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.oraclewdp.struts2.entity.User;

public class MapAction extends ActionSupport {
	//没有显式实例化就是HashMap
	private Map<String, User> userMap;

	public Map<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}
}
