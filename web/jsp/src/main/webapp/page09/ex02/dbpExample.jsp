<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page09/ex01/dbExample.jsp"%>
<sql:query var="result" dataSource="${db }">
 select id,name,price from book
 </sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL SQL Tags</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="entry" items="${result.rows }">
			<tr>
				<td>${entry.id }</td>
				<td>${entry.name}</td>
				<td>${entry.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>