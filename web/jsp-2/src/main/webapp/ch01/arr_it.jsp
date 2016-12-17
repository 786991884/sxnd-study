<%@page import="sxndjspnew.MyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MyUser[] myuser = new MyUser[2];
		MyUser u1 = new MyUser();
		u1.setName("w5");
		MyUser u2 = new MyUser();
		u2.setName("l4");
		request.setAttribute("users", myuser);
	%>
	<c:forEach var="i" items="${users }" varStatus="status">
		<c:out value="${status.index }"></c:out>
		<br>
	</c:forEach>
</body>
</html>