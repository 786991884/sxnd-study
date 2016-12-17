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
<title>插件</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.validate.messages_zh.js"></script>
<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		//第一步，引入jquery文件
		//第二步，引入validate.js
		//第三步，加载validate
		$('form').validate();
		//第四步，不得为空，给表单字段class="required"

		var user = [ 'about', 'famliy', 'but', 'black' ];
		$('form input[name=user]').autocomplete(user, {
			minChars : 0
		});

	});
</script>
<link rel="stylesheet" href="js/style.css" type="text/css" />
<link rel="stylesheet" href="js/jquery.autocomplete.css" type="text/css" />
</head>
<body>
	<form action="123.html">
		<p>
			用 户 名：<input type="text" class="required" minlength="2" name="user" /> (*)
		</p>
		<p>
			电子邮件：<input type="text" class="required email" name="email" /> (*)
		</p>
		<p>
			网 址：<input type="text" class="url" name="url" />
		</p>
		<p>
			<input type="submit" value="提交" />
		</p>
	</form>

</body>
</html>