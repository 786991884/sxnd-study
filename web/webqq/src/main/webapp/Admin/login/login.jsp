<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆后显示好友信息</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">

<script type="text/javascript" src="resource/jquery-1.8.2.js"></script>

</head>
<body>
	<div>
		<h1>我要登录</h1>
	</div>
	<div id="div"
		style="width: 250px; height: 150px; border: solid 1px red">
		<form id="myform" action="LoginServlet" method="post">
			账号: <input type="text" id="name" name="name" /> <br /> 密码: <input
				type="password" id="password" name="password" /><br> <input
				type="submit" value="登录"> <input type="reset" value="取消">
		</form>
	</div>
	<script type="text/javascript">
		$(myform.elements).hide();
		$(function viewform() {

			//$("form").removeAttr("id");
			//$("form").removeProp("id");
		});
		$("h1").bind("click", function() {
			$(myform.elements).show();
			//window.alert("sdf");
			//$("form").removeAttr("id");
		});
	</script>
</body>
</html>