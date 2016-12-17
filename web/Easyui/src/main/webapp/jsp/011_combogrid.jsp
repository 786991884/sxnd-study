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
		//自动搜索 
		$('#search').combobox({
			//data:[{id:1 ,val:'男'},{id:2 ,val:'女'}] ,
			mode : 'remote',
			url : 'UserServlet?method=searchName',
			valueField : 'id',
			textField : 'username',
			delay : 1000
		});
		//combogrid实现 			
		$('#cc').combogrid({
			panelWidth : 450,
			idField : 'id',
			textField : 'username',
			mode : 'remote',
			url : 'UserServlet?method=searchName',
			columns : [ [ {
				field : 'username',
				title : '用户名',
				width : 100
			}, {
				field : 'age',
				title : '年龄',
				width : 50
			}, {
				field : 'sex',
				title : '性别',
				width : 50,
				formatter : function(value, record, index) {
					if (value == 1) {
						return '<span style=color:red;>男</span>';
					} else if (value == 2) {
						return '<span style=color:green;>女</span>';
					}
				}
			}, {
				field : 'salary',
				title : '薪水',
				width : 100
			} ] ]
		});
	});
</script>
</head>
<body>
	自动搜索:
	<input id="search" />
	<br /> combogrid实现:
	<select id="cc" name="gridId" style="width: 250px;"></select>
</body>
</html>