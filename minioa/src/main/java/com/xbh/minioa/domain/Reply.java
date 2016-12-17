package com.xbh.minioa.domain;

import java.io.Serializable;

/**
 * 回复
 * 
 * @author Lenovo
 * 
 */
public class Reply extends Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private Topic topic;// 所属的主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
