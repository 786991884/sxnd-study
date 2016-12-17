package com.wq.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class RemoteTabAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String responseText;

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String doWebPageTab() {
		responseText = "搜索网页";
		return SUCCESS;
	}

	public String doMusicTab() {
		responseText = "搜索音乐";
		return SUCCESS;
	}

	public String doNewsTab() {
		responseText = "搜索新闻";
		return SUCCESS;
	}

	public String doPictureTab() {
		responseText = "搜索图片";
		return SUCCESS;
	}
}
