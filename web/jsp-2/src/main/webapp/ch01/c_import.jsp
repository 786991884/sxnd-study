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
	<h2>
		<c:out value="import实例"></c:out>
	</h2>
	<hr>
	<b><c:out value="绝对路径引用 的实例"></c:out></b>
	<blockquote>
		<c:import url="http://www.baidu.com"></c:import>
	</blockquote>
	<b><c:out value="使用字符串输出，绝对路径引用的实例"></c:out></b>
	<c:import var="myurl" url=""></c:import>
	<pre>
		<c:out value="${myurl }"></c:out>
	</pre>

</body>
</html>