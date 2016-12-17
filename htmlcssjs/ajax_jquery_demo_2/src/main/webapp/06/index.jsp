<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/AjaxRequest.js"></script>
<script type="text/javascript">
	/******************错误处理的方法*******************************/
	function onerror() {
		alert("您的操作有误！");
	}
	/******************实例化Ajax对象的方法*******************************/
	function getNews() {
		var loader = new net.AjaxRequest("getNews.jsp?nocache="
				+ new Date().getTime(), deal_getNews, onerror, "GET");
	}
	/************************回调函数**************************************/
	function deal_getNews() {
		document.getElementById("showNews").innerHTML = this.req.responseText;
	}
	window.onload = function() {
		getNews(); //调用getNews()方法获取公告信息
		window.setInterval("getNews()", 600000); //每隔10分钟调用一次getNews()方法
	}
</script>

<title>实时显示新闻信息</title>
</head>
<body style="font-size: 9pt;">
	<div id="showNews"></div>
</body>
</html>