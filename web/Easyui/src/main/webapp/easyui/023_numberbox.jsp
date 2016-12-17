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
	<input type="text" class="easyui-numberbox" value="100" data-options="min:0,precision:2"></input>
	<input id="dd" type="text" class="easyui-datebox" required="required"></input>
	<input class="easyui-datetimebox" name="birthday" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width: 150px">
	<div id="cc" class="easyui-calendar" style="width: 180px; height: 180px;"></div>
	<input id="ss" class="easyui-numberspinner" style="width: 80px;" required="required" data-options="min:10,max:100,editable:false">
	<input class="easyui-numberspinner" value="1234567890" style="width: 150px;" data-options="required:true,precision:2,groupSeparator:',',decimalSeparator:'.',prefix:'$'" />
	<input id="ss" class="easyui-timespinner" style="width: 80px;" required="required" data-options="min:'08:30',showSeconds:true" />
	<input class="easyui-slider" value="12" style="width: 300px" data-options="showTip:true,rule:[0,'|',25,'|',50,'|',75,'|',100]" />
</body>
</html>