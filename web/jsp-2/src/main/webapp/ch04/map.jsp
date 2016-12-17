<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map map = new HashMap();
		map.put("n1", 1);
		map.put("n2", 2);
		request.setAttribute("m", map);
	%>
	${requestScope.m.n2 }
	<br> ${requestScope.m["n2"]}
	<br>

</body>
</html>