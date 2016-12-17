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
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		request.setAttribute("myarr", arr);
	%>
	<h1>遍历前三项</h1>
	<c:forEach items="${myarr }" var="i" begin="0" end="2">
		<c:out value="${i }"></c:out>
		<br>
	</c:forEach>
	<h1>第三项以后的</h1>
	<c:forEach items="${myarr }" var="i" begin="1">
		<c:out value="${i }"></c:out>
		<br>
	</c:forEach>
	<h1>倒数第二项的前所有项</h1>
	<c:forEach items="${myarr }" var="i" end="${arr.length }">
		<c:out value="${i }"></c:out>
		<br>
	</c:forEach>
</body>
</html>