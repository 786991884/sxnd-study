<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用Student创建对象，并指定id -->
	<s:bean name="bean.Student" id="stu">
		<s:param name="name" value="'张三'" />
		<s:param name="age" value="23" />
	</s:bean>
	<!-- 根据Student实例指定的id访问JavaBean实例 -->
	我是
	<s:property value="#stu.name" />
	，今年
	<s:property value="#stu.age" />
	岁！
</body>
</html>