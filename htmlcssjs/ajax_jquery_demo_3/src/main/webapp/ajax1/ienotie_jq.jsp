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
	<input type="button" onclick="getInnerText()" value="单击">
	<p id="myp"></p>
	<script type="text/javascript">
		function getInnerText() {
			$.get("getInnerText", {
				name : "z3",
				age : "23"
			}, function(data) {
				document.getElementById("myp").innerHTML = data;
			}, "text");
			$.ajax({
				type : "get",
				url : "getInnerText",
				data : {
					name : "z3",
					age : "23"
				},
				//只有成功了都会被调用
				//readystate=4 and status=200时调用
				success : function(data) {
					document.getElementById("myp").innerHTML = data;
				},
				//失败时间调用 
				error : function() {
					document.getElementById("myp").innerHTML = "错误页面";
				},
				beforeSend : function(xhr) {
					console.log("xhr=" + xhr);
				},
				//成功或者失败函数都会被调用
				complete : function() {
					console.log("调用complete");
				},
				dataType : "text"
			});
		}
	</script>
</body>
</html>