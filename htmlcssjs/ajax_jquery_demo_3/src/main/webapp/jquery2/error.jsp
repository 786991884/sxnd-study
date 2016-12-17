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
		//在服务器端记录JavaScript错误日志
		$(window).error(function(msg, url, line) {
			jQuery.post("js_error_log.php", {
				msg : msg,
				url : url,
				line : line
			});
		});
		//隐藏javascript错误
		$(window).error(function() {
			return true;
		});
		//给你IE的用户隐藏无效的图像
		$("img").error(function() {
			$(this).hide;
		});
	</script>
</body>
</html>