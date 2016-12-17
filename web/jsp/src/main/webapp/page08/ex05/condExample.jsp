<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Conditionals</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<c:if test="${!empty param.name }">
hello ${param.name }
</c:if>
	<c:if test="${empty param.age }">
		<c:choose>
			<c:when test="${param.age<18 }">
you are a kid.
</c:when>
			<c:when test="${param.age>=18&&param.age<37 }">
		      	you are a young person.
			</c:when>
			<c:otherwise>
			you are an old personn
			</c:otherwise>
		</c:choose>
	</c:if>
	<table>
		<form method="post">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /></td>
			</tr>
		</form>
	</table>
</body>
</html>