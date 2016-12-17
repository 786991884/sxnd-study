<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax</title>
<script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#toLoadMyHtml").click(function() {
			$("#loadedHtml").load("MyHtml.html");
		});

		$("#toLoadService").click(function() {
			$("#loadedService").load("service.jsp", "name=oracle&age=100", function() {
				alert('加载完毕！');
			});
		});

		$("#toGet").click(function() {
			$.get("/ajax_jquery_demo/JqueryAjaxServlet", {
				name : 'oracle',
				age : '100'
			}, function(data) {
				$("#loadedGet").text(data);
			});
		});

		$("#toPost").click(function() {
			$.post("/ajax_jquery_demo/JqueryAjaxServlet", {
				name : '甲骨文',
				age : '100'
			}, function(data) {
				$("#loadedPost").text(data);
			});
		});

		$("#toAjax").click(function() {
			$.ajax({
				type : 'POST',
				url : '/ajax_jquery_demo/JqueryAjaxServlet',
				data : 'name=甲骨文培训&age=200',
				success : function(data) {
					$("#loadedAjax").text(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<input id="toLoadMyHtml" value="加载MyHtml" type="button">
	<input id="toLoadService" value="加载Service.jsp" type="button">
	<input id="toGet" value="$.get请求" type="button">
	<input id="toPost" value="$.post请求" type="button">
	<input id="toAjax" value="$.ajax请求" type="button">
	<br>
	<br>
	<div id="loadedHtml"></div>
	<br>
	<div id="loadedService"></div>
	<br>
	<div id="loadedGet"></div>
	<br>
	<div id="loadedPost"></div>
	<br>
	<div id="loadedAjax"></div>
</body>
</html>