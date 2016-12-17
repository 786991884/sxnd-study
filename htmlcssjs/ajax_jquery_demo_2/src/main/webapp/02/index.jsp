<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实时显示公告信息</title>
<script language="javascript" src="../js/AjaxRequest.js"></script>
<script type="text/javascript">
	/******************错误处理的方法*******************************/
	function onerror() {
		alert("您的操作有误！");
	}
	/******************实例化Ajax对象的方法*******************************/
	function getInfo() {
		var loader = new net.AjaxRequest("getInfo.jsp?nocache="
				+ new Date().getTime(), deal_getInfo, onerror, "GET");
	}
	/************************回调函数**************************************/
	function deal_getInfo() {
		document.getElementById("showInfo").innerHTML = this.req.responseText;
	}
	window.onload = function() {
		getInfo(); //调用getInfo()方法获取公告信息
		window.setInterval("getInfo()", 600000); //每隔10分钟调用一次getInfo()方法
	}
</script>
</head>
<body>
	<div
		style="border: 1px solid; height: 50px; width: 200px; padding: 5px;">
		<marquee direction="up" scrollamount="3">
			<div id="showInfo"></div>
		</marquee>
	</div>
</body>
</html>