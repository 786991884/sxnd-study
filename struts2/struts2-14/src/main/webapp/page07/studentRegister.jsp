<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册</title>
</head>
<body>
	<form action="regStudent.action" method="post">
		<table>
			<caption>学生注册</caption>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="student.name"></td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td><input type="text" name="student.birthday"></td>
			</tr>
			<tr>
				<td>移动电话:</td>
				<td><input type="text" name="student.phone"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="注册">
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>