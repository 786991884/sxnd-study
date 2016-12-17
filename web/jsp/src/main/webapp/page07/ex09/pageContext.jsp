<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL隐含对象pageContext</h2>
	<br> \${pageContext.request.queryString }:${pageContext.request.queryString }
	<br> \${pageContext.request.requestURL }:${pageContext.request.requestURL }
	<br>\${pageContext.request.contextPath}:${pageContext.request.contextPath }
	<br>\${pageContext.request.method }:${pageContext.request.method }
	<br>\${pageContext.request.protocol}:${pageContext.request.protocol}
	<br> \${pageContext.request.remoteAddr }:${pageContext.request.remoteAddr}
	<br>\${pageContext.session.id }:${pageContext.session.id }
	<br>
	<br>地址中EL隐含对象pageContext的使用
	<br>
	<br>
	<a
		href="<%=request.getContextPath()%>/page07/ex09/pageContext.jsp?Scriplet">
		使用Scriplet获得web站点根目录 </a>
	<a
		href="${pageContext.request.contextPath }/page07/ex09/pageContext.jsp?ExpressionLanguage">
		使用EL表达式获得web站点根目录</a>
</body>
</html>