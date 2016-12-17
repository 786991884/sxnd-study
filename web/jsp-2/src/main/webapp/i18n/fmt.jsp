<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="loc" value="${param.locale }"></c:set>
	<!-- 设置本地化环境 -->
	<fmt:bundle basename="com.oraclewdp.jstldemo.res">
		<br>
&nbsp;&nbsp;<fmt:message key="name"></fmt:message>
		<br>
&nbsp;&nbsp;<fmt:message key="school"></fmt:message>
		<br>
	</fmt:bundle>
	<!-- setBundle定义资源，再由message获得消息 -->
	<br>
	<fmt:setBundle var="appBundle" basename="com.oraclewdp.jstldemo.res" />
	&nbsp;&nbsp;
	<fmt:message key="avocation" bundle="${appBundle }">
		<br>
	</fmt:message>
	<!-- message标签体中使用param标签 -->
	<br>
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<fmt:formatDate value="${now }" type="both" var="currentDateString" />

	<fmt:parseDate value="${currentDateString }" type="both"
		var="currentDate"></fmt:parseDate>
	&nbsp;&nbsp;
	<fmt:message key="currentTime" bundle="${appBundle }">
		<fmt:param value="${currentDate }"></fmt:param>
	</fmt:message>
	<br> &nbsp;&nbsp;
	<fmt:message key="currentTime" bundle="${appBundle }">
		<fmt:param value="${currentDateString }"></fmt:param>
	</fmt:message>
	<br>
	<!-- message标签体中使用多个param标签 -->
	&nbsp;&nbsp;
	<fmt:message key="name" bundle="${appBundle }">
		<fmt:param value="${85 }"></fmt:param>
		<fmt:param value="${90 }"></fmt:param>
	</fmt:message>
</body>
</html>