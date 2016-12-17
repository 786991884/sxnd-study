<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>即时客服</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var strHTML = "<option selected='selected'>即时发送</option>";
		strHTML += "<option>定时发送</option>";
		$("select").html(strHTML);
	});
	function onclick_send() {
		$("#havesend").text($("#tosend").val());
	}
</script>

</head>
<body>
	<div>
		<span id="havesend"></span>
	</div>
	<br>
	<div>
		<textarea id="tosend"></textarea>
	</div>
	<br>
	<select></select>
	<input value="发送" onclick="onclick_send()" type="button">
</body>
</html>