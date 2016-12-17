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
	<p>p1</p>
	<p>p2</p>
	<script type="text/javascript">
		//只返回第一个匹配元素的html内容
		var htm1 = $("p").html();
		var htm2 = $("p")[1].innerHTML;
		console.log(htm1);
		//设置值 替换原有的内容
		$("p").html("<font color='red'>aaaa</font>");
		$("p").html(function(index, value) {
			console.log(index + ":" + value);
		});
		//设置所有 p元素的内容
		$("p").html("hello<b>world</b>");
		$("p").html(function(n) {
			return "这个p元素的index是：" + n;
		});
		//使用函数设置所有匹配元素的文本内容
		$("p").text(function(n) {
			return "这个P元素的index是:" + n;
		});
	</script>
</body>
</html>