<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="silver">
	<%
		request.setAttribute("now", new Date());
	%>
	<h2>第一种写法</h2>
	<fmt:setLocale value="zh_CN" />
	<fmt:bundle basename="com.oraclewdp.jstldemo.msg">
		<fmt:message key="login.name">
			<fmt:param value="张三"></fmt:param>
		</fmt:message>
		<fmt:message key="login.time">
			<fmt:param>1992年3月9日</fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br>
	<h1>第一种写法改写</h1>
	<fmt:setLocale value="en_US" />
	<fmt:bundle basename="com.oraclewdp.jstldemo.msg">
		<fmt:message key="login.name">
			<fmt:param value="MiDi"></fmt:param>
		</fmt:message>
		<fmt:message key="login.time">
			<fmt:param>1992-3-9</fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br>
	<h2>第二种写法</h2>
	<fmt:setLocale
		value="${fn:substringBefore(header['Accept-language'],',') }" />
	<fmt:bundle basename="com.oraclewdp.jstldemo.msg">
		<fmt:message key="login.name">
			<fmt:param>王五</fmt:param>
		</fmt:message>
		<fmt:message key="login.time">
			<fmt:param value="${now }"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br>
	<h1>简化版的写法</h1>
	<fmt:setLocale
		value="${fn:substringBefore(header['Accept-language'],',') }" />
	<fmt:bundle basename="com.oraclewdp.jstldemo.msg" prefix="login">
		<fmt:message key=".name">
			<fmt:param>李刚</fmt:param>
		</fmt:message>
		<fmt:message key=".time">
			<fmt:param value="${now }"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br>
	<h1>新的一种写法</h1>
	<fmt:setBundle var="bu" basename="com.oraclewdp.jstldemo.msg" />
	<fmt:message key="login.name" bundle="${bu }">
		<fmt:param>王麻子</fmt:param>
	</fmt:message>
	<fmt:message key="login.time" bundle="${bu }">
		<fmt:param>1996年8月8日</fmt:param>
	</fmt:message>
</body>
</html>