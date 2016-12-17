<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("a", "张三");
		session.setAttribute("name", "w8");
	%>
	<!-- 
	${"1"+1 }
	<br>${"1"+"1" } ${null+1} ${null+null }
	<br> ${pageContext.servletContext.serverInfo}
	<br> ${pageContext.request.requestURL}
	<br>${pageContext.request.requestedSessionId}
	<br> ${requestScope.a }
	<br> ${name }
	<br>${pageContext.request.localName }
	<br>${pageContext.request.queryString }
	<br>${pageContext.request.requestURI }
	<br>${pageContext.request.method }
	<br>${pageContext.request.protocol }
	<br>${pageContext.request.remoteAddr }
	<br>${pageContext.request.remoteUser }
	<br>${paramValues.productld }
	<br>${pageContext.session }
	<h1>请求参数</h1>
	${param.hobby } ${paramValues.hobby }
	<br>
	<h1>请求头</h1>
	${header.Accept } ${headerValues.Accept }
	<h1>cookie</h1>
	${cookie.JSESSIONID.name }
	<br> ${cookie.JSESSIONID.value }
	<h1>读取servletContext参数</h1>
	${initParam.uname } -->
</body>
</html>