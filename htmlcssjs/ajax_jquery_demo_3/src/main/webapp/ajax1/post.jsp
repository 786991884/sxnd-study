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
		//请求 test.php 网页，忽略返回值
		$.post("text.php");
		//请求 test.php 页面，并一起发送一些额外的数据（同时仍然忽略返回值
		$.post("text.php", {
			name : "john",
			time : "2pm"
		});
		//向服务器传递数据数组（同时仍然忽略返回值
		$.post("test.php", {
			'#choices[]' : [ "jon", "susan" ]
		});
		//使用 ajax 请求发送表单数据
		$.post("test.php", $("#testform").serialize());
		//输出来自请求页面 test.php 的结果（HTML 或 XML，取决于所返回的内容）：
		$.post("test.php", function(data) {
			alert("data loaded:" + data);
		});
		//获得 test.php 页面的内容，并存储为 XMLHttpResponse 对象，并通过 process() 这个 JavaScript 函数进行处理
		$.post("test.php", {
			name : "john",
			time : "2pm"
		}, function(data) {
			alert(data.name);
			console.log(data.time);
		}, "json");
		//获得 test.php 页面返回的 json 格式的内容
		$.post("text.php", {
			"func" : "getNameAndTime"
		}, function(data) {
			alert(data.name);
			console.log(data.time);
		}, "json");
	</script>
</body>
</html>