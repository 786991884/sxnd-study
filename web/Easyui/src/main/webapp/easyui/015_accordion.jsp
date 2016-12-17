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
		$('#aa').accordion({
			animate : false
		});
		var p = $('#aa').accordion('getSelected');
		if (p) {
			var index = $('#aa').accordion('getPanelIndex', p);
			alert(index);
		}

	});
</script>
</head>
<body>
	<div id="aa" class="easyui-accordion" style="width: 300px; height: 200px;">
		<div title="Title1" data-options="iconCls:'icon-save'" style="overflow: auto; padding: 10px;">
			<h3 style="color: #0099FF;">Accordion for jQuery</h3>
			<p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
		</div>
		<div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding: 10px;">content2</div>
		<div title="Title3">content3</div>
	</div>
</body>
</html>