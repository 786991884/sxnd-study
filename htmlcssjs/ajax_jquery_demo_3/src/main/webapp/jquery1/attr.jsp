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
		$("img").attr("src", "images/1.jpg");
		$("img").attr({
			src : "images/1.jpg",
			title : "222"
		});
	});
	$("img").attr("title", function() {
		return this.src;
	});
	function del() {
		$("img").removeAttr("src");
	}
</script>
</head>
<body>
	<img id="img1">
	<br>
	<img id="img2">
</body>
</html>