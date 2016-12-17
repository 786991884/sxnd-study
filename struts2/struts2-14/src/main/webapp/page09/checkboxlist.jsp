<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:checkboxlist name="booklist"
		list="{'corejava','html/css','javascript','sql'}">
	</s:checkboxlist>
	<hr>
	<s:checkboxlist name="bookmap"
		list="#{'corejava':'jdk7','sql':'oracle11g'}" listKey="key"
		listValue="value"></s:checkboxlist>
	<hr>
	<s:bean name="biz.BookBiz" id="bookBiz"></s:bean>
	<s:checkboxlist name="bookBizlist" list="#bookBiz.books"
		listKey="bookName" listValue="bookVersion"></s:checkboxlist>
</body>
</html>