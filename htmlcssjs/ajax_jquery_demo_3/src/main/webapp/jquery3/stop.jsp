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
	<button id="go">Go</button>
	<button id="stop">STOP!</button>
	<div class="block"></div>
	<button id="go">Go</button>
	<button id="stop">STOP!</button>
	<div class="block"></div>
	<script type="text/javascript">
		//点击Go之后开始动画,点Stop之后会在当前位置停下来
		// 开始动画
		$("#go").click(function() {
			$(".block").animate({
				left : '+200px'
			}, 5000);
		});

		// 当点击按钮后停止动画
		$("#stop").click(function() {
			$(".block").stop();
		});
	</script>
</body>
</html>