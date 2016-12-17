<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String strName = request.getParameter("name");
	String strAge = request.getParameter("age");
	out.print("来自service.jsp=姓名：" + strName + "；年龄：" + strAge);
%>