<%@page import="java.util.ArrayList"%>
<%@page import="ch08.estore.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("1", "jsp", 55));
		books.add(new Book("3", "java", 77));
		books.add(new Book("5", "servlet", 44));
		books.add(new Book("6", "ssh", 100));
		pageContext.setAttribute("books", books);
	%>
	<c:forEach items="${pageScope.books }" var="book">
	${book.id }:${book.name }:${book.price }<br>
	</c:forEach>
</body>
</html>