<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#tt').combotree({
			url : 'ResourceServlet?method=loadTree',
			width : 500,
			multiple : true,
			checkbox : true
		});
		$('#btn1').click(function() {
			console.info($('#tt').combotree('getValues'));
		});
		$('#btn2').click(function() {
			//console.info($('#tt').combotree('tree'));
			var tree = $('#tt').combotree('tree');
			var root = tree.tree('getRoot');
			console.info(root);
		});
	});
</script>
</head>
<body>
	<input id="tt">
	<a id="btn1" class="easyui-linkbutton">获取tree选中的值</a>
	<a id="btn2" class="easyui-linkbutton">返回tree对象</a>
</body>
</html>