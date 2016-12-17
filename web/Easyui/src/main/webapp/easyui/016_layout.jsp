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
		$('#cc').layout('add', {
			region : 'west',
			width : 180,
			title : 'West Title',
			split : true,
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('add')
				}
			}, {
				iconCls : 'icon-remove',
				handler : function() {
					alert('remove')
				}
			} ]
		});
	});
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width: 600px; height: 400px;">
		<div data-options="region:'north',title:'North Title',split:true" style="height: 100px;"></div>
		<div data-options="region:'south',title:'South Title',split:true" style="height: 100px;"></div>
		<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width: 100px;"></div>
		<div data-options="region:'center',title:'center title'" style="padding: 5px; background: #eee;"></div>
	</div>
</body>
</html>