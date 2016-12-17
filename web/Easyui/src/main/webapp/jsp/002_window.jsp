<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		/* $('#mypanel').panel({
			title : '我的面板',
			width : 600,
			height : 300,
			iconCls : 'icon-edit',
			collapsible : 'true',
			closable : 'true',
			content : '我是面板内容',
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('new');
				}
			}, {
				iconCls : 'icon-save',
				handler : function() {
					alert('save');
				}
			} ]
		}); */
		/* $('#mywin').window({
			content : '我是窗口的内容',
			onOpen : function() {
				alert("窗口打开了");
			}
		});
		$('#btn').click(function() {
			$('#mywin').window('open');
		}); */
		$('#dialog').dialog({
			title : '我是对话框',
			iconCls : 'icon-ok',
			toolbar : [ {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					alert('新增了');
				}
			}, {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					alert('修改了');
				}
			} ],
			buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					alert('确定了');
				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					alert('取消了');
				}
			} ]
		});
	});
</script>
<body>
	<!-- 使用组件的方式： 1 html  2 js -->
	<!-- <div id="mypanel" class="easyui-panel"
		style="width: 500px; height: 300px" title="我的panel"
	iconCls="icon-add" minimizable="true" maximizable="true"
	collapsible="true" closable="true"	>我是panel的内容</div> -->
	<!-- 	<div id="mypanel"></div> -->
	<div id="mywin" class="easyui-window" style="width: 500px; height: 300px" title="我的窗口" draggable="true" closed="true" shadow="true" resizable="false" modal="false"></div>
	<a id="btn" class="easyui-linkbutton">点击我</a>
	<div id="dialog" class="easyui-dialog" style="width: 500px; height: 300px"></div>
</body>
</html>