<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date now = new Date();
		request.setAttribute("date", now);
	%>
	<!-- 数据源连接 如果某一列没有出现在要插入的列表中，那么它的值要么是默认值，要么是null-->
	<sql:setDataSource var="ds" user="root" password="1234"
		url="jdbc:mysql://localhost:3306/test" driver="com.mysql.jdbc.Driver" />
	<sql:transaction dataSource="${ds }">
		<sql:update
			sql="insert into user(userid,userpassword,userauthority,birthday) values(?,?,?,?)"
			var="res">
			<sql:param value="小胖"></sql:param>
			<sql:param>5678</sql:param>
			<sql:param value="99"></sql:param>
			<sql:param value="${date }"></sql:param>
		</sql:update>
		<sql:update
			sql="insert into user(userid,userpassword,userauthority,birthday) values(?,?,?,?)"
			var="res">
			<sql:param value="小红"></sql:param>
			<sql:param>3567</sql:param>
			<sql:param value="78"></sql:param>
			<sql:param value="${date }"></sql:param>
		</sql:update>
	</sql:transaction>
</body>
</html>