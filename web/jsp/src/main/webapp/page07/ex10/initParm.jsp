<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 隐含对象initParam</h2>
	<br>地址中EL隐含对象pageContext的使用
	<br>
	<a
		href="<%=application.getInitParameter("contextPath")%>/page07/ex10/initParam.jsp?Scriplet">使用Scriplet获取站点根目录</a>
	<br>
	<br>
	<a
		href="${initParam.contextPath}/page07/ex10/initParam.jsp?ExpressionLanguage">使用EL表达式获取站点根目录</a>
	<a></a>
</body>
</html>