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
	<p></p>
	<script type="text/javascript">
		//触发所有段落的blur事件
		$("p").blur();
		//任何段落失去焦点时弹出一个 "Hello World!"在每一个匹配元素的blur事件中绑定的处理函数
		$("p").blur(function() {
			alert("hello world");
		});
		//触发被选元素的 change 事件
		$("selector").change();
		//给所有的文本框增加输入验证
		$("input[type='text']").change(function() {
		});
	</script>
</body>
</html>