<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XML Tags</title>
</head>
<body>
	<fmt:setLocale value="zh" />
	<fmt:bundle basename="messages.MessageResources">
		<fmt:message>name</fmt:message>
		<br>
		<fmt:message>gender</fmt:message>
		<br>
		<fmt:message>birthday</fmt:message>
		<br>
	</fmt:bundle>
	<fmt:setLocale value="z1" />
	<fmt:bundle basename="messages.MessageResources">
		<fmt:message>name</fmt:message>
		<br>
		<fmt:message>gender</fmt:message>
		<br>
		<fmt:message>birthday</fmt:message>
		<br>
	</fmt:bundle>
	<fmt:setLocale value="us" />
	<fmt:bundle basename="messages.MessageResources">
		<fmt:message>name</fmt:message>
		<br>
		<fmt:message>gender</fmt:message>
		<br>
		<fmt:message>birthday</fmt:message>
	</fmt:bundle>
</body>
</html>