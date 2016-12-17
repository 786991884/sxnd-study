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
	<div style="background-color: green; display: none">aaaaaaa</div>
	<input type="button" value="p" id="myb" style="display: none">
	<p style="display: none">徐冰浩</p>
	<script type="text/javascript">
		$("div").fadeIn("slow");
		//使用淡入效果来显示一个隐藏的 <p> 元素
		$(".myb").click(function() {
			$("p").fadeIn();
		});
		//用200毫秒快速将段落的透明度调整到0.25，大约1/4的可见度，之后弹出一个对话框
		$("p").fadeTo("fast", 0.25, function() {
			alert("Animation Done.");
		});
	</script>
</body>
</html>