<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="regAction.action" method="post">
		<table>
			<caption>用户注册</caption>
			<tr>
				<td>用户名:</td>
				<!-- 封装用户名的请求参数为user.name,与Action里面属性相对应 -->
				<td><input type="text" name="user.name"></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<!-- 封装用户名的请求参数为user.age,与Action里面属性相对应 -->
				<td><input type="text" name="user.age"></td>
			</tr>
			<tr>
				<td>毕业时间:</td>
				<!-- 封装用户名的请求参数为user.graduationDate,与Action里面属性相对应 -->
				<td><input type="text" name="user.graduationDate"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交">
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>