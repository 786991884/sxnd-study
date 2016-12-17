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
<script type="text/javascript" src="js/util.js"></script>
<title>Insert title here</title>
</head>
<body>
	<input type="button" onclick="getInnerText()" value="单击">
	<p id="myp"></p>
	<script type="text/javascript">
		function getInnerText() {
			xhr = createXHR();
			$.getJSON("getInnerJSON", {
				name : "z3"
			}, function(data) {
				resTxt = "name" + data.name;
				resTxt1 = "age" + data.age;
				document.getElementById("myp").innerHTML = resTxt;
				document.getElementById("myp").innerHTML = resTxt1;
			});
		};
		//设置 AJAX 请求默认地址为 "/xmlhttp/"，禁止触发全局 AJAX 事件，用 POST 代替默认 GET 方法。其后的 AJAX 请求不再设置任何选项参数
		$.ajaxSetup({
			url : "/xmlhttp/",
			global : false,
			type : "POST"
		});
		$.ajax({
			data : myData
		});
	</script>
</body>
</html>