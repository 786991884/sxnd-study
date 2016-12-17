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
	1.只指定value值形式
	<br />
	<s:url value="delete.action" />
	<hr />
	2.指定action属性，且使用param传入参数形式
	<br />
	<s:url action="delete">
		<s:param name="num" value="100" />
	</s:url>
	<hr />
	3.不指定action和value属性，使用param传入参数形式
	<br />
	<s:url includeParams="get" namespace="/">
		<s:param name="id" value="%{'100'}" />
	</s:url>
	<hr />
	4.指定action和value属性，使用param传入参数形式
	<br />
	<s:url action="update" value="demo">
		<s:param name="price" value="100" />
	</s:url>
</body>
</html>