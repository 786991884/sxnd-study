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
		//在页面内对键盘按键做出回应，可以使用如下代码
		$(window).keydown(function(event) {
			switch (event.keyCode) {
			}
		});
		//计算在输入域中的按键次数
		$("input").keydown(function() {
			$("span").text(i += 1);
		});
		//当按下按键时，改变文本域的颜色
		$("input").keyup(function() {
			$("input").css("background-color", "#d6d6ff");
		});
	</script>
</body>
</html>