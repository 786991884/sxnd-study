<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	String strName = request.getParameter("sName");
	System.out.println("客户的姓名：" + strName);
	int iRandom = (int) (Math.random() * 10);
	if (iRandom % 2 == 1) {
		out.print("yes");
	} else if (iRandom % 2 == 0) {
		out.print("no");
	}
%>
