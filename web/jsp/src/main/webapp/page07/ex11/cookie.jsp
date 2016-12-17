<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL隐含对象cookie</h2>
	<br>使用Scriplet输出Cookie的内容
	<%
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			out.print("<br>" + cookie.getName() + ":" + cookie.getValue());
		}
	%>
	<br>
	<br>使用EL表达式输出Cookie的内容
	<br>${cookie.username.name }:${cookie.username.value }
	<br>${cookie.JSESSIONID.name }:${cookie.JSESSIONID.value }
</body>
</html>