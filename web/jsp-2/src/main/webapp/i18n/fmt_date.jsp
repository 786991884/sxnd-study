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
	<fmt:timeZone value="EST">
		<jsp:useBean id="currentTime" class="java.util.Date"></jsp:useBean>
		<!-- 中文，中国显示格式 -->
		<h2>Chinese,China</h2>
		<fmt:setLocale value="zh_CN" />
		<fmt:formatDate type="both" timeStyle="full" value="${currentTime }" />
		<br>
		<!-- 英语 ，英国显示格式 -->
		<h2>English,Great Britain</h2>
		<fmt:setLocale value="en_GB" />
		<fmt:formatDate type="both" dateStyle="full" value="${currentTime }" />
		<br>
		<!-- 英语 ，美国显示格式 -->
		<h2>English,USA</h2>
		<fmt:setLocale value="en_US" />
		<fmt:formatDate type="both" dateStyle="full" value="${currentTime }" />
		<br>
	</fmt:timeZone>
</body>
</html>