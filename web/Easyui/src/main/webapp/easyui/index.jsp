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
		$('#loginAndRegDialog').dialog({
			title : '用户登录',
			width : 300,
			height : 200,
			closed : false,
			cache : false,
			//href: 'get_content.php', 
			closable : false,
			modal : true,
			buttons : [ {
				text : '注册',
				handler : function() {
				}
			}, {
				text : '登录',
				handler : function() {
					if ($('#loginInputForm').form('validate')) {
						$.ajax({
							type : 'post',
							url : 'userAction!login.action',
							data : $('#loginInputForm').serialize(),
							dataType : 'json',
							success : function(r) {
								if (r && r.success) {
									$('#loginAndRegDialog').dialog('close');
									$.messager.show({
										title : '提示信息',
										msg : r.msg
									});
								} else {
									$.messager.alert('标题', r.msg);
								}
							}
						});

					} else {
						$.messager.show({
							title : '提示信息',
							msg : '表单验证不通过'
						});
					}
				}
			} ]
		});
		$('#loginInputForm').find('input').on('keyup', function(event) {
			if (event.keyCode == '13') {
				$('#loginInputForm').submit();
			}
		});

	});
</script>
</head>
<body>
	<div id="loginAndRegDialog">
		<form method="post" id="loginInputForm">
			<table>
				<tr>
					<th>用户名</th>
					<td><input name="name" class="easyui-validatebox" data-options="required:true"></td>
				<tr>
				<tr>
					<th>密码</th>
					<td><input type="password" name="password" class="easyui-validatebox" data-options="required:true"></td>
				<tr>
			</table>
		</form>
	</div>

</body>
</html>