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
	<!-- var:暴露出的变量名 value：变量值 scope作用范围 默认为page-->
	<c:set var="name" value="z3" scope="request"></c:set>
	${requestScope.name }
	<br>
	<c:out value="${requestScope.name }"></c:out>
	<br>
	<c:remove var="name" scope="request" />
	<jsp:useBean id="user" class="jstldemo.User" scope="request"></jsp:useBean>
	<c:set target="${user}" property="name" value="w8"></c:set>
	${requestScope.user.name}

	<c:set var="name" value="w8" scope="request"></c:set>
	<c:out value="${requestScope.name }"></c:out>
	<c:remove var="name" scope="request" />

	<c:set target="${user }" property="name" value="25"></c:set>
	${requestScope.user.name }


	<h1>用标签体给变量赋值</h1>
	<c:set var="passward" scope="request">789</c:set>
	<!-- 这里把标签体作为变量的值 ，不要同时即指定value又指定标签体-->
	${passward }

	<h2>set标签实例</h2>
	<c:set var="num1" scope="request" value="${3/6 }"></c:set>
	<c:set var="num2" scope="session" value="${3+5 }"></c:set>
	<c:set var="num3" scope="session" value="01"></c:set>
	<br>
	<!-- 通过out标签输出变量值 -->
	num1变量值为：
	<c:out value="${num1 }"></c:out>
	<br> num2变量值为：
	<c:out value="${num2 }"></c:out>
	<br> num3变量值为：
	<c:out value="${num3 }"></c:out>
	<br>
</body>
</html>