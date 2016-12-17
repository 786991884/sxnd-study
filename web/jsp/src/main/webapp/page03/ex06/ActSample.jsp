<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Include Action Sample</title>
</head>
<body>
	<jsp:include page="banner.html"></jsp:include>
	<jsp:include page="date.jsp">
		<jsp:param value="123一二三" name="user" />
	</jsp:include>
</body>
</html>