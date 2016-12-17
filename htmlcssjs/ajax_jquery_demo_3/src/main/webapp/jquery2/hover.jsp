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
		//鼠标悬停的表格加上特定的类
		$("td").hover(function() {
			$(this).addClass("hover");
		}, function() {
			$(this).removeClass("hover");
		});
		//hovre()方法通过绑定变量"handlerInOut"来切换方法
		$("td").bind("mouseenter mouseleave", handlerInOut);
		$("td").hover(handlerInOut);
		//对表格切换显示/隐藏
		//用600毫秒的时间将段落缓慢的切换显示状态
	</script>
</body>
</html>