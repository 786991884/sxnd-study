<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage"></s:text></title>
</head>
<body>
	<s:form action="Login">
		<s:textfield name="username" key="user"></s:textfield>
		<s:textfield name="password" key="pass"></s:textfield>
		<s:submit key="login"></s:submit>
	</s:form>
</body>
</html>