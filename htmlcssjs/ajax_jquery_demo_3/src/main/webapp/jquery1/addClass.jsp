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
	<p>徐冰浩</p>
	<div></div>
	<div></div>
	<ul>
		<li>hello</li>
		<li>hello</li>
		<li>hello</li>
	</ul>
	<script type="text/javascript">
		$("p").addClass("selected");
		$("p").addClass("selected1 selected2");
		//给li加上不同的class
		$('ul li:last').addClass(function() {
			return 'item-' + $(this).index();
		});
		//从匹配元素中删除selected类
		$("p").removeClass("selected");
		$("p").removeClass();
		$('li:last').removeClass(function() {
			return $(this).prev().attr('class');
		});
		//切换类
		$("p").toggleClass("selected");
		var count = 0;
		$("p").click(function() {
			$(this).toggleClass("hightlight", count++ % 3 == 0);
		});
	</script>
</body>
</html>