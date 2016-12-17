<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>即时客服（事件处理）</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var strHTML = "<option selected='selected'>即时发送</option>";
		strHTML += "<option>定时发送</option>";
		$("select").html(strHTML);

		$("#toSend").bind("click", function() {
			$("#havesend").text($("#tosend").val());
		});
		$("#toSend").bind("click", function() {
			$("#msg").text("正在发送...");
		});
		$("#toSend").one("dblclick", function() {
			alert("请单击发送按钮！")
		});
		$("#toExit").bind("click", function() {
			$("#toSend").unbind("click");
		});
	});
</script>
</head>
<body>
	<div id="msg"></div>
	<br>
	<div>
		<span id="havesend"></span>
	</div>
	<br>
	<div>
		<textarea id="tosend"></textarea>
	</div>
	<br>
	<select></select>
	<input id="toSend" value="发送" type="button">
	<input id="toExit" value="离线" type="button">
</body>
</html>