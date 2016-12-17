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
	<form>
		<label>Name:</label> <input name="name" />
		<fieldset>
			<label>Newsletter:</label> <input name="newsletter" />
		</fieldset>
	</form>
	<input name="none" />
	<p id="myp"></p>
	<script type="text/javascript">
		window.onload = function() {
		};
		$(document).ready(function() {

			var tp = document.getElementById("myp");
			console.log(tp);
			console.log($("form input"));
		});
		$(function() {
		});
	</script>
</body>
</html>