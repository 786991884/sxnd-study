<%@page import="java.util.ArrayList"%>
<%@page import="ch07.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="ch07.entity.User" scope="session"></jsp:useBean>
	<br>输出对象username属性的值：${sessionScope.user.username }，是否为空：${empty sessionScope.user.username }
	<jsp:setProperty property="username" name="user" value="" />
	<br>输出对象username属性的值：${sessionScope.user.username}，是否为空：${empty sessionScope.user.username }
	<jsp:setProperty property="username" name="user" value="sun" />
	<br>输出对象username属性的值：${sessionScope.user.username }，是否为空：${empty sessionScope.user.username }
	<br>--------------------------------------------------------------------------------------------------
	<%
		List<User> users = new ArrayList<User>();
		users.add(new User("sun"));
		users.add(new User("oracle"));
		pageContext.setAttribute("users", users);
	%>
	<br> 第二个用户的用户名是: ${pageScope.users[1].username }
</body>
</html>