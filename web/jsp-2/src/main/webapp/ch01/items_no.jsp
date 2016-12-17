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
	<c:forEach var="i" begin="20" end="50" varStatus="status" step="2">
		<c:out value="${i }"></c:out>
		<br>
		<c:if test="${status.last }">
		总数是：
			<c:out value="${status.count }"></c:out>

		</c:if>
	</c:forEach>
</body>
</html>