<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		//按tab键切换输入参数
		/* $.messager.alert('提示信息', '我是信息内容', 'error', function() {

		}); */
		/* $.messager.confirm('提示信息', '确认么', function(r) {
			if (r) {
				alert('点击确认');
			} else {
				alert('点击取消');
			}
		}); */
		/* $.messager.prompt('提示信息', '请输入内容：', function(val) {
			alert(val);
		}); */
		/* $.messager.progress({
			title : '我是进度条',
			msg : '文本内容',
			text : '正在加载...',
			interval : 1000
		}); */
		$.messager.show({
			title : '提示信息',
			msg : '我是内容'
		});

	});
</script>
<body>

</body>
</html>