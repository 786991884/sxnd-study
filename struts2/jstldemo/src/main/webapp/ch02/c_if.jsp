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
	<h1>if标签实例</h1>
	<c:set var="num" scope="page" value="admin"></c:set>
	<c:if test="${num=='admin' }" var="condition" scope="page">
你好！admin
</c:if>
	<c:out value="这里判断结果：${condition }"></c:out>
	<br>
	<c:if test="${num=='guest' }" var="condition" scope="page">你好</c:if>
	<c:out value="这里判断结果：${condition }"></c:out>
</body>
</html>