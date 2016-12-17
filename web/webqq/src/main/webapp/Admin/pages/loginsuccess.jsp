<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="Admin/js/ajax.js"></script>
<script type="text/javascript" src="resource/jquery-1.8.2.js"></script>
<script type="text/javascript" src="Admin/js/util.js"></script>
</head>
<body>
	<div style="width: 400px; height: 500px; background-color: blue">
		<div id="myhello"></div>
		<div id="friends" style="height: 50px; background-color: red"></div>
		<div id="my" ></div>
		<div id="hello" onclick="getFriends()">
			<a>嘻呵呵，你好</a>
		</div>
	</div>
	<a href="Admin/login/login.jsp"><h1>退出登陆</h1></a>
</body>
</html>