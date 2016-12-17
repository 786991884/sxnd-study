<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<%--fmt:setLocale value=“zh-CN" /--%>
	<ul>
		<li>Formatting current date as "GMT":<br> <fmt:timeZone
				value="GMT">
				<fmt:formatDate value="${now}" type="both" dateStyle="full"
					timeStyle="full" />
			</fmt:timeZone>
		<li>Formatting current date as "GMT+1:00", and parsing its date
			and time components:<br> <fmt:timeZone value="GMT+1:00">
				<fmt:formatDate value="${now}" type="both" dateStyle="full"
					timeStyle="full" var="formatted" />
				<fmt:parseDate value="${formatted}" type="both" dateStyle="full"
					timeStyle="full" var="parsedDateTime" />
   		Parsed date: <fmt:formatDate value="${parsedDateTime}" type="date"
					dateStyle="full" />
				<br>
   		Parsed time: <fmt:formatDate value="${parsedDateTime}" type="time"
					timeStyle="full" />
			</fmt:timeZone> <fmt:setLocale value="en_US" /><br> <fmt:formatNumber
				value="0.99" type="currency" /><br> <fmt:parseNumber
				value="99%" type="percent" var="myper" /> ${myper }<br> <fmt:formatDate
				value="${now}" type="both" dateStyle="full" timeStyle="full" />
</body>
</html>