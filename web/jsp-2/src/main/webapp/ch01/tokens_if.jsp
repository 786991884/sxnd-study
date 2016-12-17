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
	<!-- items指定用来分割字符串 delims:指定按照什么方式分割 var:访问分割的的集合的每一项的指针 -->
	<c:forTokens items="I'm a student" delims=" '" var="word">
		<c:out value="${word }"></c:out>
		<br>
	</c:forTokens>
</body>
</html>