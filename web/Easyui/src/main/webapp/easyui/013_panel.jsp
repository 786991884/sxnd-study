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
		$('#p').panel({
			width : 500,
			height : 150,
			title : 'My Panel',
			fit : true,
			border : false,
			collapsible : true,
			//不设置面版标题
			//noheader : true,
			//在初始化的时候折叠面板
			collapsed : true,
			closable : true,
			style : {
				borderWidth : 2
			},
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
		});
		$('#a').click(function() {
			$('#p').panel('move', {
				left : 100,
				top : 100
			});
		});
	});
</script>
</head>
<body>
	<div id="p" style="padding: 10px;">
		<p>panel content.</p>
		<p>panel content.</p>
		<button id="a">1313</button>
	</div>
</body>
</html>