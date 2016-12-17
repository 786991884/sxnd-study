<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<body>
	<script type="text/javascript">
		//对表格切换显示/隐藏
		$('td').toggle();
		//对表格的切换一个类
		$("td").toggle(function() {
			$(this).addClass("selected");
		}, function() {
			$(this).removeClass("selected");
		});
		//以滑动方式显示隐藏的 <p> 元素
		$(".btn2").click(function() {
			$("p").slideDown();
		});
		//用200毫秒快速将段落滑上，之后弹出一个对话框
		$("p").slideUp("fast", function() {
			alert("Animation Done.");
		});
		//用600毫秒缓慢的将段落滑上或滑下
		$("p").slideToggle("fast", function() {
			alert("Animation Done.");
		});
	</script>
</body>
</html>