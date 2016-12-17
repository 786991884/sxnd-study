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
	<p>徐冰浩</p>
	<div></div>
	<div></div>
	<script type="text/javascript">
		//选中复选框为true没选中为false
		$("input[type='checkbox']").prop("checked");
		//禁用页面上的所有复选框
		$("input[type='checkbox']").prop({
			disabled : true
		});
		//禁用和选中页面上的复选框
		$("input[type='checkbox']").prop("disabled", false);
		$("input[type='checkbox']").prop("checked", true);
		//通过函数设置
		$("input[type='checkbox']").prop("checked", function(i, val) {
			return !val
		});
	</script>
</body>
</html>