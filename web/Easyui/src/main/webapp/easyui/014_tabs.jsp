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
		$('#tt').tabs({
			fit : true,
			border : false,
			toolPosition : 'left',
			tabPosition : 'left',
			headerWidth : 150,
			onSelect : function(title) {
				alert(title + ' is selected');
			},
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('添加');
				}
			}, {
				iconCls : 'icon-save',
				handler : function() {
					alert('保存');
				}
			} ]

		});

		// add a new tab panel    
		$('#tt').tabs('add', {
			title : 'New Tab',
			content : 'Tab Body',
			closable : true,
			tools : [ {
				iconCls : 'icon-mini-refresh',
				handler : function() {
					alert('refresh');
				}
			} ]
		});
	});
</script>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="width: 500px; height: 250px;">
		<div title="Tab1" style="padding: 20px; display: none;">tab1</div>
		<div title="Tab2" data-options="closable:true" style="overflow: auto; padding: 20px; display: none;">tab2</div>
		<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding: 20px; display: none;">tab3</div>
	</div>
</body>
</html>