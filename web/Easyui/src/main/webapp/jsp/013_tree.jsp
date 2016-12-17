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
		$('#t2').tree({
			url : 'jsp/013_tree.json',
			animate : true,
			checkbox : true,
			cascadeCheck : false,
			onlyLeafCheck : true,
			dnd : true
		});
	});
	//获取根节点
	function getRoot() {
		console.info($('#t2').tree('getRoot'));
	}
	//获取子节点
	function getChildren() {
		var root = $('#t2').tree('getRoot');
		console.info($('#t2').tree('getChildren', root.target));
	}
	//获取选中的节点
	function getChecked() {
		console.info($('#t2').tree('getChecked'));
	}
	//是否是叶子节点
	function isLeaf() {
		var sel = $('#t2').tree('getSelected');
		console.info($('#t2').tree('isLeaf', sel.target));
	}
	//切换折叠状态
	function toggle() {
		var root = $('#t2').tree('getRoot'); //object
		$('#t2').tree('toggle', root.target);
	}
</script>
</head>
<body>
	<!-- 纯html渲染tree -->
	<!-- <ul id="t1" class="easyui-tree">
		<li><span>根节点</span>
			<ul>
				<li><span>节点1</span></li>
				<li><span>节点2</span></li>
				<li><span>节点3</span></li>
				<li><span>节点4</span></li>
			</ul></li>
	</ul> -->
	<!-- js方式初始化tree -->
	<ul id="t2">
	</ul>
	<br>
	<input type="button" onclick="getRoot()" value="获取跟节点" />
	<input type="button" onclick="getChildren()" value="获取子节点" />
	<input type="button" onclick="getChecked()" value="获取勾选的节点" />
	<input type="button" onclick="isLeaf()" value="是否是叶子节点" />
	<input type="button" onclick="toggle()" value="切换节点状态" />
</body>
</html>