<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="TestActionContext.action?name=atguigu">Test ActionContext</a>
	
	<br><br>
	
	<a href="TestAware.do?name=atguigu">Test Aware</a>

	<br><br>
	
	<a href="testActionSupport.do">Test ActionSupport</a>

	<br><br>
	
	<a href="testResult.do?number=4">Test Result</a>

	<br><br>
	
	<a href="testDynamicMethodInvocation.do">Test DynamicMethodInvocation</a>

	<% 
		if(application.getAttribute("date") == null)
			application.setAttribute("date", new Date());
	
		request.setAttribute("req", "reqvalue");
	%>
	
</body>
</html>