<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态JSP页面</title>
</head>
<body>
	<%!int i = 0;%>
	<%
		i++;
	%>
	<p>
		您是<%=i%>个访问本站的客户
	</p>
</body>
</html>