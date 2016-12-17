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
		//当按下鼠标按钮时，隐藏或显示元素
		$("button").mousedown(function() {
			$("p").slideToggle();
		});
		//当鼠标指针进入（穿过）元素时，改变元素的背景色
		$("p").mouseenter(function() {
			$("p").css("background-color", "yellow");
		});
		//当鼠标指针离开元素时，改变元素的背景色
		$("p").mouseout(function() {
			$("p").css("background-color", "#E9E9E4");
		});
		//获得鼠标指针在页面中的位置
		$(document).mousemove(function(e) {
			$("span").text(e.pageX + "," + e.pageY);
		});
		//当鼠标从元素上移开时，改变元素的背景色
		$("p").mouseout(function() {
			$("p").css("background-color", "red");
		});
		//当鼠标指针位于元素上方时时，改变元素的背景色
		$("p").mouseover(function() {
			$("p").css("background-color", "yellow");
		});
		$("button").mouseup(function() {
			$("p").slideToggle();
		});
	</script>
</body>
</html>