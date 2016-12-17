<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册信息</title>
</head>
<body>
	我是
	<s:property value="student.name" />
	出生于
	<s:property value="student.birthday" />
	联系方式是
	<s:property value="student.phone" />
</body>
</html>