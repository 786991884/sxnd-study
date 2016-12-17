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
	<!-- 输入内容到页面 -->
	<c:out value="${header['Accept'] }"></c:out>
	<br>
	<!-- value计算结果为空时输出 default -->
	<c:out value="${header['Accept1'] }" default="aaaa"></c:out>
	<!-- 是否对特殊字符进行转义，也即转为实体，默认值是true默认进行转义 -->
	<c:out value="<a>cc</a>" escapeXml="true"></c:out>

	<c:out value="${header['Host']}"></c:out>
	<c:out value="<a>cc</a>" escapeXml="false"></c:out>
	<c:out value="<p>有特殊字符</p>"></c:out>
	<br>
	<c:out value="<p>有特殊字符</p>" escapeXml="false"></c:out>
</body>
</html>