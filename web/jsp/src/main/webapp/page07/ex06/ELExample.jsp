<%@page import="ch07.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="useBean.jsp"></jsp:include>
	使用Scriplet输出：
	<%
		User user = (User) session.getAttribute("user");
		out.print(user.getUsername());
	%>
	<br> 使用EL输出：${sessionScope.user.username }
</body>
</html>