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
		request.setAttribute("mark", 75);
	%>
	<!-- 顺序很重要，otherwise放在最后 -->
	<c:choose>
		<c:when test="${requestScope.mark>85 }">优秀</c:when>
		<c:when test="${requestScope.mark>80 }">良好</c:when>
		<c:when test="${requestScope.mark>75 }">好</c:when>
		<c:otherwise>一般</c:otherwise>
	</c:choose>
</body>
</html>