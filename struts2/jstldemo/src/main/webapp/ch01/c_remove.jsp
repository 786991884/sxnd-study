<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 通过set标签赋值 -->
	<c:set var="num" scope="page" value="${2+4 }"></c:set>
	<c:set var="num" scope="request">${3+6 }</c:set>
	<c:set var="num" scope="session">
		<c:out value="19"></c:out>
	</c:set>
	<!-- 变量显示 -->
	<table border="1" width="50%">
		<tr>
			<td>pageScope.num</td>
			<td>c:out value="${pageScope.num}" default="null"</td>
		</tr>
		<tr>
			<td>requestScope.num</td>
			<td>c:out value="${requestScope.num}" default="null"</td>
		</tr>
		<tr>
			<td>sessionScope.num</td>
			<td>c:out value="${sessionScope.num}" default="null"</td>
		</tr>
	</table>
	<!-- 使用remove标签删除num之后(scope没有指定，即把所有范围内的变量删除，变量值的显示) -->
	<c:out value='<c:remove var="num" scope="page"'></c:out>
	<c:remove var="num" scope="page" />
	<table border="1" width="50%">
		<tr>
			<td>pageScope.num</td>
			<td><c:out value="${pageScope.num }" default="null"></c:out></td>
		</tr>
		<tr>
			<td>requestScope.num</td>
			<td><c:out value="${requestScope.num }" default="null"></c:out></td>
		</tr>
		<tr>
			<td>sessionScope.num</td>
			<td><c:out value="${sessionScope.num }" default="null"></c:out></td>
		</tr>
	</table>
</body>
</html>