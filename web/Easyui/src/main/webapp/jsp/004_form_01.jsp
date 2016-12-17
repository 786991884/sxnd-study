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
		$.extend($.fn.validatebox.defaults.rules,
				{
					midLength : {
						validator : function(value, param) {
							return value.length >= param[0]
									&& value.length <= param[1];
						},
						message : '请输入{0}-{1}字符.'
					},
					equalLength : {
						validator : function(value, param) {
							return value.length == param[0];
						},
						message : '必须输入{0}个字符.'
					}
				});
		//数值验证组件
		$('#age').numberbox({
			min : 0,
			max : 120,
			required : true,
			missingMessage : '年龄必须填',
			precision : 0
		});
		//日期组件
		$('#birthday').datebox({
			required : true,
			missingMessage : '生日必须填',
			editable : false
		});
		$('#salary').numberbox({
			min : 1000,
			max : 20000,
			required : true,
			missingMessage : '薪水必须填',
			precision : 2
		});
		//日期时间组件
		$('#startTime,#endTime').datetimebox({
			required : true,
			missingMessage : '时间必须填',
			editable : false
		});
	});
</script>
</head>
<body>
	<div id="mydiv" class="easyui-panel"
		style="width: 500px; height: 350px" title="用户新增">
		<form action="" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"
						class="easyui-validatebox" required="true"
						validType="midLength[2,5]" missingMessage="用户名必须填"
						invalidMessage="" value=""></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"
						class="easyui-validatebox" required="true"
						validType="equalLength[4]" missingMessage="密码必须填" value=""></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>男<input type="radio" name="sex" checked="checked"
						value="1"> 女<input type="radio" name="sex" value="2"></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" id="age" name="age" value=""></td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input type="text" id="birthday" name="birthday" value=""
						style="width: 155px;"></td>
				</tr>
				<tr>
					<td>所属城市：</td>
					<td><input name="city" valueField="id" textField="name"
						style="width: 155px;" class="easyui-combobox"
						url="UserServlet?method=getCity" value="">
					<td>
				</tr>
				<tr>
					<td>薪水：</td>
					<td><input type="text" id="salary" name="salary" value=""></td>
				</tr>
				<tr>
					<td>开始时间：</td>
					<td><input type="text" id="startTime" name="startTime"
						style="width: 155px;" value=""></td>
				</tr>
				<tr>
					<td>结束时间：</td>
					<td><input type="text" id="endTime" name="endTime" value=""
						style="width: 155px;"></td>
				</tr>
				<tr>
					<td>个人描述：</td>
					<td><input type="text" name="description" value=""
						class="easyui-validatebox" required="true"
						validType="midLength[5,50]" missingMessage="个人描述必须填"
						invalidMessage=""></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a class="easyui-linkbutton">保存</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>