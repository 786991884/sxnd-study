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
		$('#mm').menu('show', {
			left : 200,
			top : 100
		});
	});
</script>
</head>
<body>
	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div>New</div>
		<div>
			<span>Open</span>
			<div style="width: 150px;">
				<div>
					<b>Word</b>
				</div>
				<div>Excel</div>
				<div>PowerPoint</div>
			</div>
		</div>
		<div data-options="iconCls:'icon-save'">Save</div>
		<div class="menu-sep"></div>
		<div>Exit</div>
	</div>
	<div class="easyui-menu" data-options="onClick:menuHandler" style="width: 120px;">
		<div data-options="name:'new'">新建</div>
		<div data-options="name:'save',iconCls:'icon-save'">保存</div>
		<div data-options="name:'print',iconCls:'icon-print'">打印</div>
		<div class="menu-sep"></div>
		<div data-options="name:'exit'">退出</div>
	</div>
	<script type="text/javascript">
		function menuHandler(item) {
			alert(item.name)
		}
	</script>


</body>
</html>