<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expression Sample</title>
</head>
<body>
	<h2>
		Current time:<%=new Date()%><br> Random number:<%=Math.random()%><br>
		Simple String:<%="Hello, world"%><br> Simple statment 1+1:<%=1 + 1%><br>
		Visit implicit object:remote host is:<%=request.getRemoteHost()%>
	</h2>
</body>
</html>