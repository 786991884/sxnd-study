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
<link rel="stylesheet" type="text/css" href="css/common.css">
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
		$('a[title]').click(function() {
			var src = $(this).attr('title');
			var title = $(this).html();//取得文本值
			if ($('#tt').tabs('exists',title)) {
				$('#tt').tabs('select',title);
			}else{
				// add a new tab panel   
				$('#tt').tabs('add', {
					title : title,
					content : '<iframe frameborder=0 style=width:100%;height:100%; src='+src+'></iframe>',
					closable : true
				});
			}
		});
	});
</script>
</head>
<body>
<body class="easyui-layout" fit=true>
	<div region="north" title="主页面" iconCls="icon-ok" split="true"
		style="height: 100px;"></div>
	<!-- <div region="south" title="South Title" split="true"
		style="height: 100px;"></div>
	<div region="east"  collapsed="true" iconCls="icon-reload" title="East" split="true"
		style="width: 100px;"></div> -->
	<div region="west" split="true" title="菜单" style="width: 200px;">
		<div id="aa" fit=true class="easyui-accordion"
			style="width: 300px; height: 200px;">
			<div title="用户管理" iconCls="icon-save"
				style="overflow: auto; padding: 10px;">
				<h3 style="color: #0099FF;">Accordion for jQuery</h3>
				<a title="jsp/001_messager.jsp">用户列表</a><br> <a
					title="jsp/002_window.jsp">用户功能</a>
			</div>
			<div title="岗位管理" iconCls="icon-reload" selected="true"
				style="padding: 10px;">content2</div>
			<div title="权限管理">content3</div>
			<div title="资源管理">content4</div>
		</div>
	</div>
	<div region="center" title="主界面"
		style="padding: 5px; background: #eee;">
		<div id="tt" fit=true class="easyui-tabs"
			style="width: 500px; height: 250px;">
			<div title="Tab1" style="padding: 20px; display: none;">tab1</div>
			<div title="Tab2" closable="true"
				style="overflow: auto; padding: 20px; display: none;">tab2</div>
			<div title="Tab3" iconCls="icon-reload" closable="true"
				style="padding: 20px; display: none;">tab3</div>
		</div>
	</div>
</body>
</body>




</html>