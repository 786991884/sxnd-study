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
<style type="text/css">
#css1 {
	width: 100px;
	height: 20px;
	background-color: blue;
}
</style>
<script type="text/javascript">
	$(function() {
		$("p").css("color");
		//$("p").css({color:"green",background:"red"});
		//$("p").css("color","blue");
		$("div").click(function() {
			$(this).css({
				width : function(index, value) {
					return parseFloat(value) * 1.1;
				},
				height : function(index, value) {
					return parseFloat(value) * 1.1;
				}
			});
		});
	});
</script>
</head>
<body>
	<p>哈哈哈哈哈</p>
	<div id="css1">徐冰浩</div>
</body>
</html>