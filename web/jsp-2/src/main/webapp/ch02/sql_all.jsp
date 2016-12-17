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
<body bgcolor="#ffffff">
	<h2>SQL标签库</h2>
	<hr>
	<%
		session.setAttribute("myDbDriver", "com.mysql.jdbc.Driver");
		session.setAttribute("myDbUrl", "jdbc:mysql://localhost:3306/test");
		session.setAttribute("myDbUserName", "root");
		session.setAttribute("myDbPassword", "1234");
	%>
	<!-- 首先设定数据库的连接 
	<sql:setDataSource var="example" driver="${sessionScope.myDbDriver }"
		url="${sessionScope.myDbUrl }" user="${sessionScope.myDbUserName }"
		password="${sessionScope.myDbPassword }" />-->
	<sql:setDataSource var="example" user="root" password="1234"
		url="jdbc:mysql://localhost:3306/test" driver="com.mysql.jdbc.Driver" />
	<!-- 把数据库查询和更新操作放在一个事务中 -->
	<sql:transaction dataSource="${example }">
		<!-- 使用sql:update>标签创建一个数据库表 -->
		<sql:update var="newTable"
			sql="create table mytable (nameid int primary key,name varchar(80))">
		</sql:update>
		<!-- 向mytable表中插入数据 -->
		<sql:update var="updateCount">
		insert into mytable values(1,'tom')
		</sql:update>
		<!-- 向mytable表中插入数据，并使用sql:param 标签插入参数值 -->
		<sql:update var="updateCount">
		insert into mytable values(?,'Johnson')
        <sql:param value="2"></sql:param>
		</sql:update>
		<!-- 向mytable表中插入数据 -->
		<sql:update var="updateCount">
 		insert into mytable values(?,?)
 		<sql:param value="3"></sql:param>
			<sql:param value="李四"></sql:param>
		</sql:update>
		<!-- 查询数据库表mytable中所有内容 -->
		<sql:query var="deejay">
 		select*from mytable
 		</sql:query>
	</sql:transaction>
	<!-- 对返回的Result结果中的每行的列进行迭代处理，取出每一列 -->
	<table border="1">
		<c:forEach var="row" items="${deejay.rowsByIndex }">

			<tr>
				<c:forEach var="column" items="${row }">
					<td><c:out value="${column }"></c:out></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<!-- 没有指定每行的列索引，注意与上面的不同，这里可以指定取出哪一列 -->
	<table border="1">
		<c:forEach var="row" items="${deejay.rows }">

			<tr>
				<td><c:out value="${row.nameid }"></c:out></td>
				<td><c:out value="${row.name }"></c:out></td>
			</tr>
		</c:forEach>

	</table>
	<!-- 把mytable数据表删除 -->
	<sql:update var="newTable" dataSource="${example }">
		drop table mytable
	</sql:update>
</body>
</html>