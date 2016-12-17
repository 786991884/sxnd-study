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
	<h2>forEach标签实例</h2>
	<hr>
	<%
		String items[] = new String[5];
		items[0] = "核心标签库";
		items[1] = "国际化标签库";
		items[2] = "SQL标签库";
		items[3] = "XML标签库";
		items[4] = "函数标签库";
		request.setAttribute("items", items);
	%>
	<b><c:out value="不指定begin和end的迭代"></c:out></b>
	<br>
	<c:forEach var="item" items="${items }">
&nbsp;<c:out value="${item }"></c:out>
		<br>
	</c:forEach>
	<b><c:out value="指定begin和end的迭代"></c:out></b>
	<br>
	<c:forEach var="item" items="${items }" begin="1" end="3" step="1">
	&nbsp;<c:out value="${item }"></c:out>
		<br>
	</c:forEach>
	<b><c:out value="输出整个迭代的信息："></c:out></b>
	<br>
	<c:forEach var="item" items="${items }" begin="3" end="4" step="1"
		varStatus="s">
	&nbsp;<c:out value="${item }"></c:out>
		<br>
	&nbsp;&nbsp;所在位置，即索引：<c:out value="${s.index }"></c:out>
		<br>
	&nbsp;&nbsp;总共已迭代的次数：<c:out value="${s.count }"></c:out>
		<br>
	&nbsp;&nbsp;是否为第一个位置：<c:out value="${s.first }"></c:out>
		<br>
	&nbsp;&nbsp;是否为最后一个位置：<c:out value="${s.last }"></c:out>
        <br>
	</c:forEach>
</body>
</html>