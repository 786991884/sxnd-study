<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="forTokens实例"></c:out>
	</h1>
	<c:forTokens var="token"
		items="bleu,blanc,rouge|vert,jaune|blanc,rouge" delims="|">
&nbsp;&nbsp;<c:out value="${token }"></c:out>
	</c:forTokens>
	<h2>使用|和，一起做分隔符</h2>
	<c:forTokens var="token"
		items="bleu,blanc,rouge|vert,jaune|blanc,rouge" delims="|,">
	&nbsp;&nbsp;<c:out value="${token }"></c:out>
	</c:forTokens>
</body>
</html>