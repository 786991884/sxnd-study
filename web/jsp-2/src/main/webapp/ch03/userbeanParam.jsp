<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sxndjsp.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="sxndjsp.entity.User" scope="request"></jsp:useBean>
	<jsp:setProperty property="name" name="user" param="uname" />
	<jsp:setProperty property="age" name="user" param="age" />
	<!-- property写上*号，意思是把请求参数里跟bean相同的属性赋值 -->
	<jsp:setProperty property="*" name="user" />
	<jsp:getProperty property="name" name="user" />
	<jsp:getProperty property="age" name="user" />
</body>
</html>