<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'hello.jsp' starting pageInsert title here</title>
</head>
<body>
	<%!public String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		return df.format(new Date());
	}%>
	<%@include file="banner.html"%><br>欢迎：
	<%="sun"%>!
	<br>当前时间是：<%=getDate()%>
	<%@include file="copyright.jsp"%>
</body>
</html>