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
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		console.log($('p').css("color"));
		console.log($('p').css('color', "green"));
		$("p").css({
			color : "green",
			"font-size" : +50
		});
		$("div").click(function() {
			$(this).css({});
		});
	});
</script>
</head>
<body>
	<p>哈哈哈哈哈</p>
</body>
</html>