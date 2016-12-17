<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>事件触发</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#msg").bind("me", function() {
			alert($(this).text());
		});
		$("#msg").bind("mouseover", function() {
			$("#msg").trigger("me");
		});

		$("input").focus(function() {
			$("<span>单击一次！</span>").appendTo("body");
		});
		$("#ok").click(function() {
			$("input").trigger("focus");
			//$("input").triggerHandler("focus");
		});
	});
</script>
</head>
<body>
	<div id="msg">鼠标，看过来！</div>
	<br>
	<br>
	<a id="ok">测试事件触发</a>
	<input value="button" type="button">
</body>
</html>