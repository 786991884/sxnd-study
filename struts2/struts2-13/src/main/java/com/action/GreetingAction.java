package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class GreetingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 用户名
	private String username;

	// 处理请求
	@Override
	public String execute() throws Exception {
		if (username == null || "".equals(username)) {
			// 返回到错误页面
			return ERROR;
		} else {
			// 返回到成功页面
			return SUCCESS;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
