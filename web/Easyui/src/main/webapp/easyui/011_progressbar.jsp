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
		$('#p').progressbar({
			value : 60,
			onChange : function(newValue, oldValue) {
				//change();
				//alert(newValue);
			}
		});
		$('#p').click(function() {
			var value = $('#p').progressbar('getValue');
			if (value < 100) {
				value += Math.floor(Math.random() * 10);
				$('#p').progressbar('setValue', value);
			}
		});
	});
</script>
</head>
<body>
	<div id="p" style="width: 400px;"></div>
</body>
</html>