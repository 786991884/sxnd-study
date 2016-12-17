<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		Map map = new HashMap();
		map.put("name", "z3");
		map.put("pwd", "345");
		//Set keys = map.keySet();
		request.setAttribute("m", map);
	%>
	<!-- items表示你要遍历的集合 var就是引用集合每一项的‘指针’
	对于map，每一项的类型是Map.Entry,该类有getKey和getValue方法 -->
	<c:forEach items="${m }" var="entry">
	key:	<c:out value="${entry.key }"></c:out>
		<br>
	value:	<c:out value="${entry.value }"></c:out>
		<br>
	</c:forEach>
</body>
</html>