<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>remove标签</title>
</head>
<body>
	<h1>remove标签</h1>
	<br>给变量赋值
	<c:set var="name" value="sun" scope="page"></c:set>
	${pageScope.name }
	<br>给对象的属性赋值
	<jsp:useBean id="book" class="ch08.estore.Book" scope="page" />
	<c:set target="${pageScope.book}" property="name" value="jsp" />
	${pageScope.book.name}
	<br>使用remove标签之前 "${pageScope.book.name }"
	<c:remove var="book" scope="page" />
	<br>使用remove标签之后 "${pageScope.book.name }"
</body>
</html>