<%@page import="java.util.HashMap"%>
<%@page import="ch08.estore.Book"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String, Book> books = new HashMap<String, Book>();
		books.put("1", new Book("1", "jsp", 55));
		books.put("3", new Book("3", "java", 77));
		books.put("5", new Book("5", "servlet", 44));
		books.put("6", new Book("6", "ssh", 100));
		pageContext.setAttribute("books", books);
	%>
	<c:forEach items="${pageScope.books }" var="entry">
	${entry.key }:${entry.value.id }:${entry.value.name }<br>
	</c:forEach>
</body>
</html>