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
		$(window).resize(function() {
			alert("stop it");
		});
		//对浏览器窗口调整大小进行计数
		$(window).resize(function() {
			$("span").text(x += 1);
		});
		//当页面滚动条变化时，执行的函数
		$(window).scroll(function() {
		});
		//对元素滚动的次数进行计数
		$("div").scroll(function() {
			$("span").text(x += 1);
		});
		//触发所有input元素的select事件
		$("input").select();
		//当文本框中文本被选中时执行的函数
		$(":text").select(function() {
		});
		//提交本页的第一个表单
		$("form:first").submit();
		//如果你要阻止表单提交
		$("form").submit(function() {
			return false;
		});
		//页面卸载的时候弹出一个警告框
		$(window).unload(function() {
			alert("bye");
		});
	</script>
</body>
</html>