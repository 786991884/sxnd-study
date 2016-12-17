<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>知问前端</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.ui.js"></script>
<script type="text/javascript">
	$(function() {
		$('#search_button').button();

		$('#reg_a').click(function() {
			$('#reg').dialog();
		});

	});
</script>
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
<link rel="stylesheet" href="css/smoothness/jquery.ui.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<div id="header">
		<div class="header_main">
			<h1>知问</h1>
			<div class="header_search">
				<input type="text" name="search" class="search" />
			</div>
			<div class="header_button">
				<input type="button" value="查询" id="search_button" />
			</div>
			<div class="header_member">
				<a href="###" id="reg_a">注册</a> | <a href="###" id="login_a">登录</a>
			</div>
		</div>
	</div>


	<div id="reg" title="会员注册">表单区</div>

</body>
</html>