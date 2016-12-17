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
<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
	<div id="div1"><img alt="1" src="images/1.jpg"></div>
	<div id="div2">bbb</div>
	<input type="button" value="单击" onclick="insertDiv()">
	<script type="text/javascript">
		function insertDiv() {
			//通过ajax拿远端内容，并覆盖掉已有内容
			$("div").load("a.txt");
		};
		$("#div1").ajaxStart(function() {
			$("#div1").css("display", "block");
		});
		$("#div1").ajaxComplete(function() {
			$("#div1").css("display", "none");
		});
	</script>
</body>
</html>