<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标签</title>
</head>
<body>
	<h1>out标签赋值的两种使用方式</h1>
	<br>value表示要输出的值
	<br>default表示默认的值，如果value中的值为空则输出default的值
	<br>如果escapeXml的值是true，则不需要字符转换
	<br>
	<br>给变量赋值
	<c:set var="name" value="sun" scope="page"></c:set>
	<br>${pageScope.name }
	<hr>
	<br>给对象的属性赋值
	<jsp:useBean id="book" class="ch08.estore.Book" scope="page"></jsp:useBean>
	<c:set target="${pageScope.book }" property="name" value="jsp"></c:set>
	"${pageScope.book.name }"
	<br>
	<c:out value="${pageScope.book.name}" />
	<c:remove var="book" scope="page" />
	<br>使用remove标签之后
	<br>"${pageScope.book.name }"
	<br>
	<c:out value="${pageScope.book.name }" default="book对象不存在！！！"></c:out>
	<br>
	<c:out value="${pageScope.book.name }">
		<font color="blue">book对象不存在！</font>
	</c:out>
	<br>
	<c:out value="${pageScope.book.name }" escapeXml="false">
		<font color="blue">book对象不存在！</font>
	</c:out>
</body>
</html>