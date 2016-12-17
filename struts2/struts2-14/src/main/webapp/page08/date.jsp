<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date(112, 5, 1, 8, 8);
		pageContext.setAttribute("datetime", date);
	%>
	1.nice="false",日期格式设置为yyyy/MM/dd
	<br />
	<s:date name="#attr.datetime" format="yyyy/MM/dd" nice="false" />
	<hr />
	2.nice="true",日期格式设置为yyyy/MM/dd
	<br />
	<s:date name="#attr.datetime" format="yyyy/MM/dd" nice="true" />
	<hr />
	3.nice="true"
	<br />
	<s:date name="#attr.datetime" nice="true" />
	<hr />
	4.nice="false"
	<br />
	<s:date name="#attr.datetime" nice="false" />
	<hr />
	<s:debug />
</body>
</html>
