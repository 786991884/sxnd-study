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
	});
</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="My Panel" style="width: 500px; height: 150px; padding: 10px; background: #fafafa;" data-options="iconCls:'icon-save',closable:true,   
                collapsible:true,minimizable:true,maximizable:true">
		<p>panel content.</p>
		<p>panel content.</p>
	</div>
</body>
</html>