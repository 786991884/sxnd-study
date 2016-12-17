<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		var index1 = $("li").index(document.getElementById('bar'));
		console.log(index1);
		var index2 = $("li").index($('#bar'));
		var index3 = $("li").index($('li:gt(0)'));
		var index4 = $("#bar").index('li');
		var index5 = $('#bar').index();
		console.log(index2);
		console.log(index3);
		console.log(index4);
		console.log(index5);
		console.log($('li').length);
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li id="foo">foo</li>
		<li id="bar">bar</li>
		<li id="baz">baz</li>
	</ul>
</body>
</html>