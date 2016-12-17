<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请输入您的注册信息</title>
</head>
<body>
	<h1>请输入您的注册信息</h1>
	<s:form action="regist">
		<s:textfield label="用户名" name="name"></s:textfield>
		<s:password label="密码" name="pass" />
		<s:password label="确认密码" name="rpass" />
		<s:textfield label="年龄" name="age" />
		<s:textfield label="电话" name="phone" />
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>