<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<h2>fn.length()</h2>
	<hr>
	<c:set var="s1" value="There is a castle on a cloud"></c:set>
	<%
		String[] customers = { "tom", "johnson", "jake" };
		session.setAttribute("customers", customers);
	%>
	<table cellpadding="5" border="1">
		<tr>
			<td align="left">Input String</td>
			<td>Result</td>
		</tr>

		<tr>
			<td>${s1 }</td>
			<td>${fn:length(s1)}</td>
		</tr>
		<tr>
			<td>${customers }</td>
			<td>${fn:length(customers) }</td>
		</tr>
		<tr>
			<td>null</td>
			<td>${fn:length(undefined) }</td>
		</tr>
		<tr>
			<td>empty string</td>
			<td>${fn:length("") }</td>
		</tr>

	</table>
</body>
</html>