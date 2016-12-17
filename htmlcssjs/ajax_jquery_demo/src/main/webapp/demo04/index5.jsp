<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取好友（对象操作函数）</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var arrOnlineFriend = [];
		var jOnlineFriend = $("#myfriend>[class='online']");
		jOnlineFriend.each(function() {
			arrOnlineFriend.push(this.id);
		});
		alert(jOnlineFriend.length);
		alert(jOnlineFriend.size());
		alert(arrOnlineFriend.toString());
	});
</script>

</head>
<body>
	<span>我的好友</span>
	<br>
	<div id="myfriend">
		<div id="friend10000" class="online"></div>
		<div id="friend10001" class="online"></div>
		<div id="friend10002" class="online"></div>
		<div id="friend10003" class="no"></div>
		<div id="friend10004" class="no"></div>
		<div id="friend10005" class="online"></div>
	</div>
</body>
</html>