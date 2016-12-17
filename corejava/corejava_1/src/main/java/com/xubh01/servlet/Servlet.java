package com.xubh01.servlet;

import com.xubh01.server.Request;
import com.xubh01.server.Response;

/**
 * 抽象为一个父类
 *
 */
public abstract class Servlet {
	public void service(Request req,Response rep) throws Exception{
		this.doGet(req,rep);
		this.doPost(req,rep);
	}

	protected abstract void doGet(Request req,Response rep) throws Exception;
	protected abstract void doPost(Request req,Response rep) throws Exception;
}
