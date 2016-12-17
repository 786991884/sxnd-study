package com.xubh01.server.demo4;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req,Response rep) throws Exception {
		String name = req.getParameter("uname");
		String pwd =req.getParameter("pwd");
		if(login(name,pwd)){
			rep.println("登录成功");
		}else{
			rep.println("登录失败");
		}



	}


	public boolean login(String name,String pwd){
		return name.equals("xubh02") && pwd.equals("12346");
	}


	@Override
	public void doPost(Request req,Response rep) throws Exception {

	}

}
