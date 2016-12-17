<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sj:head />
</head>
<body>
	<sj:dialog id="mydialoy" title="对话框简介">
可改变大小，移动位置
</sj:dialog>
	<sj:dialog id="myclickdialog" autoOpen="false" modal="true"
		title="模态对话框">
点击链接弹出对话框
</sj:dialog>
	<sj:a openDialog="myclickdialog" cssClass=""></sj:a>
</body>
</html>