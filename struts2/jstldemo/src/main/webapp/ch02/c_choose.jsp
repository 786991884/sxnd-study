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
	<h2>choose标签实例</h2>
	<c:set var="num" scope="page" value="admin"></c:set>
	<c:choose>
		<c:when test="${num=='guest' }">
			<c:out value="guest"></c:out>
		</c:when>
		<c:when test="${num=='admin' }">
			<c:out value="admin"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="other"></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>