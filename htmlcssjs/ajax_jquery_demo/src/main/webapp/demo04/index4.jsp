<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录（学习核心函数）</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var obj = $("span");
		alert(obj[0].innerHTML + obj.get(0).innerHTML);

		var str = "<div><span>账号：</span><input>";
		str += "<br><span>密码：</span><input></div>";
		var objLogin = $(str);
		objLogin.appendTo("body");

		$(function() {
			alert("请输入账号信息！")
		});
	});
</script>

</head>
<body>
	<span>下面是登录框：</span>
</body>
</html>