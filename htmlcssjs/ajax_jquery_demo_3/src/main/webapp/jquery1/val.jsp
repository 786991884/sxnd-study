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
	<input value="123">
	<select>
		<!--option没有指定value就是内部的值 -->
		<option value="1">男</option>
		<option value="2" selected="selected">女</option>
	</select>
	<script type="text/javascript">
		//读取值
		console.log($("input").val());
		console.log($("select").val());
		//赋值
		$("input").val("456");
		//这里只能是已有的值
		$("select").val("1");
		//通过函数设定文本框中的值
		$('input:text.items').val(function() {
			return this.value + '' + this.className;
		});
	</script>
</body>
</html>