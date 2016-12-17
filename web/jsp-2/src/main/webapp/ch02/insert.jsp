<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="ds" user="root" password="1234"
		url="jdbc:mysql://localhost:3306/test" driver="com.mysql.jdbc.Driver" />
	<sql:update dataSource="${ds }"
		sql="insert into user(userid,userpassword,userauthority) values(?,?,?)" var="res">
		<sql:param value="王八"></sql:param>
		<sql:param>6789</sql:param>
		<sql:param value="99"></sql:param>
	</sql:update>
	受影响的行数：${res }
</body>
</html>