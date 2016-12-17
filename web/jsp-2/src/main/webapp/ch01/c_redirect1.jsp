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
	<!-- 这个页面内容不会显示出来，因为直接重定向到c_redirect2.jsp页面上 -->
	<c:redirect url="c_redirect2.jsp">
		<c:param name="userName" value="admin"></c:param>
	</c:redirect>
</body>
</html>