<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>解析XML</h1>
	<c:set var="xmlTest">
		<a> <b> <c>good</c>
		</b> <d> <c>baby</c> </d>
		</a>
	</c:set>
	<x:parse var="xmlDoc" doc="${xmlTest }"></x:parse>
	<x:out select="$xmlDoc//c" />
	<br>
	<x:out select="$xmlDoc/a/d" />
	<br>

</body>
</html>