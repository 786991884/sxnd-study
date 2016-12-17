<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
</head>
<body>
	<form action="dologin.jsp" method="post">
		<table height="150" width="300">
			<tr>
				<td align="center" colspan="4" height="20">
					<%
						if (request.getAttribute("errorinfo") != null) {
							out.print(request.getAttribute("errorinfo"));
						}
					%>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="4">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</body>
</html>