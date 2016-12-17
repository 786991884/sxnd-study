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
	<button id="go">run</button>
	<div id="block">hello</div>
	<button id="left">«</button>
	<button id="right">»</button>
	<div class="block"></div>
	<script type="text/javascript">
		//在一个动画中同时应用三种类型的效果
		$("#go").click(function() {
			$("block").animate({
				width : "90px",
				height : "100%",
				fontSize : "10em",
				borderWidth : 10
			}, 1000);
		});
		//让指定元素左右移动
		$("#right").click(function() {
			$(".block").animate({
				left : '+50px'
			}, "slow");
		});

		$("#left").click(function() {
			$(".block").animate({
				left : '-50px'
			}, "slow");
		});
		//在600毫秒内切换段落的高度和透明度
		$("p").animate({
			left : 50,
			opacity : 'slow'
		}, 500);
		//停止当前正在运行的动画
		$("#stop").click(function() {
			$("#box").stop();
		});
		
	</script>
</body>
</html>