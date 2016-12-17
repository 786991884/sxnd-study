<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello world !</title>
</head>
<body>
	<h2>
		<!--如果该标签返回的是对象，那么 就调用该对象的toString方法  -->
		<s:property value="messageStore" />
		<br>
		<!--调用方法，但是这个访问不能静态 -->
		<s:property value="messageStore。toString()" />
		<br>
		<s:property value="messageStore.message"></s:property>
	</h2>
	<p>
		I've said hello
		<s:property value="helloCount">times!</s:property>
		<s:property value="@@"/>
	</p>
</body>
</html>