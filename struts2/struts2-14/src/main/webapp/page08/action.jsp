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
	调用第一个Action，并将结果包含到本页面
	<br />
	<s:action name="logic1" namespace="/"
		executeResult="true" />
	<hr />
	调用第二个Action，并将结果包含到本页面
	<br /> 阻止本页面请求参数传入Action
	<br />
	<s:action name="logic2" namespace="/"
		executeResult="true" ignoreContextParams="true" />
	<hr />
	调用第二个Action，不将结果包含到本页面
	<br />
	<s:action name="logic2" namespace="/"
		executeResult="false" />
	<s:property value="#attr.num" />
</body>
</html>