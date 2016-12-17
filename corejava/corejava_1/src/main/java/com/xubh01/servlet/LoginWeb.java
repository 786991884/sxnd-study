package com.xubh01.servlet;

import com.xubh01.server.Request;
import com.xubh01.server.Response;

public class LoginWeb extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		rep.println("success.....");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {

	}

}
