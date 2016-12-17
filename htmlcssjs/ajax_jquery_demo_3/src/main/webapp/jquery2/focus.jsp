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
	<p>
		<input type="text" /> <span>focusout fire</span>
	</p>
	<p>
		<input type="password" /> <span>focusout fire</span>
	</p>
	<script type="text/javascript">
		//当页面加载后将 id 为 'login' 的元素设置焦点
		$(document).ready(function() {
			$('#login').focus();
		});
		//使人无法使用文本框
		$("input[type=text]").focus(function() {
			this.blur();
		});
		//获得焦点后会触发动画
		$("p").focusin(function() {
			$(this).find("span").css('display', 'inline').fadeOut(1000);
		});
		//失去焦点后会触发动画
		$("p").focusout(function() {
			$(this).find("span").css('display', 'inline').fadeOut(1000);
		});
	</script>
</body>
</html>