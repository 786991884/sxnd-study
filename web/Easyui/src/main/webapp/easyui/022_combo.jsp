<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.5/themes/icon.css" />
<script type="text/javascript" src="js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#cc').combogrid({
			delay : 500,
			mode : 'remote',
			url : 'get_data.php',
			idField : 'id',
			textField : 'name',
			columns : [ [ {
				field : 'code',
				title : 'Code',
				width : 120,
				sortable : true
			}, {
				field : 'name',
				title : 'Name',
				width : 400,
				sortable : true
			} ] ]
		});
	});
</script>
</head>
<body>
	<input id="cc" name="dept" value="01" />
</body>
</html>