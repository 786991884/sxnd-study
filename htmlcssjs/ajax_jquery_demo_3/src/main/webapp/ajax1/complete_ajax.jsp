<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
	<script type="text/javascript">
		//AJAX 请求完成时执行函数
		$("msg").ajaxComplete(function(event, request, settings) {
			$(this).append(<li>请求完成</li>);
		});
		//当 AJAX 请求正在进行时显示“正在加载”的指示
		$("#txt").ajaxStart(function() {
			$("#wait").css("display", "block");
		});
		$("#txt").ajaxComplete(function() {
			$("#wait").css("display", "none");
		});

		//AJAX 请求失败时显示信息
		$("#msg").ajaxError(function(event, request, settings) {
			$(this).append("<li>出错页面：" + settings.url + "</li>");
		});
		//AJAX 请求发送前显示信息
		$("#msg").ajaxSend(function(evt, request, settings) {
			$(this).append("<li>开始请求: " + settings.url + "</li>");
		});
		//AJAX 请求开始时显示信息
		$("#loading").ajaxStart(function() {
			$(this).show();
		});
		//AJAX 请求结束后隐藏信息
		$("#loading").ajaxStop(function() {
			$(this).hide();
		});
		//当 AJAX 请求成功后显示消息
		$("#msg").ajaxSuccess(function(evt, request, settings) {
			$(this).append("<li>请求成功!</li>");
		});
	</script>
</body>
</html>