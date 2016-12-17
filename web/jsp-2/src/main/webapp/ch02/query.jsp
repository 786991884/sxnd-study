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
<body bgcolor="green">
	<!-- 数据源连接 -->
	<sql:setDataSource var="ds" user="root" password="1234"
		url="jdbc:mysql://localhost:3306/test" driver="com.mysql.jdbc.Driver" />
	<!-- maxRows/如果没有指定或者指定为-1则不限定指定结果集
		maxRows和startRow配合起来可以做分页 -->
	<sql:query var="rs" dataSource="${ds }" sql="select*from user"
		startRow="0" maxRows="4"></sql:query>
	<c:choose>
		<c:when test="${rs.rowCount>0}">

			<table border="1">
				<c:forEach items="${rs.rows }" var="row">
					<tr>
						<td><c:out value="${row.userid }"></c:out> <br></td>
						<td><c:out value="${row.userpassword}"></c:out> <br></td>
						<td><c:out value="${row.userauthority }"></c:out> <br></td>
						<td><c:out value="${row['birthday'] }"></c:out> <br></td>
					</tr>
				</c:forEach>
			</table>

		</c:when>
		<c:otherwise>
			<tr>
				<td>${rs.columnNames[0] }</td>
				<td>${rs.columnNames[1] }</td>
				<td>${rs.columnNames[2] }</td>
				<td>${rs.columnNames[3] }</td>
			</tr>
			<tr>
				<td colspan="4">无数据</td>
			</tr>
		</c:otherwise>
	</c:choose>
</body>
</html>