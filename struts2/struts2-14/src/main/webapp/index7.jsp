<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>声明资源的国际化</title>
</head>
<body>
	<h3>使用i18n标签将ApplicationResources资源包压入值栈，使用嵌套的text标签获取本地化消息</h3>
	用户名：
	<s:text name="username"></s:text>
	<br> 性别：
	<s:text name="sex"></s:text>
	<br> 日期：
	<%
		pageContext.setAttribute("now", new Date());
	%>
	<!-- 使用嵌套的param标签为消息文本中的参数设值，第一个param标签为{0)参数设值，第二个param标签为{1}参数设值 -->
	<s:text name="now">
		<s:param value="#attr.now"></s:param>
		<s:param value="'mrsof'"></s:param>
	</s:text>
</body>
</html>