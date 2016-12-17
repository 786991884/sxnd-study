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
		$('#sel_1').combobox(
				{onSelect : function() {
						var pid = $('#sel_1').combobox('getValue');
						$('#sel_2').combobox('setValue', '');
						$('#sel_2').combobox('reload','ProvinceServlet?method=getCity&pid=' + pid);
					}
				});
		//自动搜索 
		$('#search').combobox({
			//data:[{id:1 ,val:'男'},{id:2 ,val:'女'}] ,
			mode : 'remote',
			url : 'UserServlet?method=searchName',
			valueField : 'id',
			textField : 'username',
			delay : 1000
		});
	});
</script>
</head>
<body>
	<select id="sel_1" class="easyui-combobox"
		url="ProvinceServlet?method=getPro" valueField="id" textField="name"></select>
	<select id="sel_2" class="easyui-combobox" valueField="id"
		textField="name"></select> 自动搜索:
	<input id="search" />
	<br />
</body>
</html>