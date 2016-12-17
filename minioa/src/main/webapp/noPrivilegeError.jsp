<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>没有权限</title>
<%@include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /> 提示
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!--显示表单内容-->
	<div id="MainArea">
		<div class="ItemBlock_Title1"></div>

		<div class="ItemBlockBorder" style="margin-left: 15px;">
			<div class="ItemBlock" style="text-align: center; font-size: 16px;">出错了，您没有权限访问此功能！</div>
		</div>

		<!-- 操作 -->
		<div id="InputDetailBar">
			<a href="javascript:history.go(-1);"><IMG src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
		</div>
	</div>
</body>
</html>
