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
</head>
<body>
	<form action="login.action" method="post" name="form1">
		<table width="319" border="1" align="center" bgcolor="#FFFFFF">
			<caption>
				<h3>
					<br> <br> 论坛登录
				</h3>
			</caption>
			<tr align="center" bgcolor="#85C7FC">
				<td width="105" height="26"><div align="center">用户名：</div></td>
				<td width="198"><label>
						<div align="left">
							<input type="text" name="username">
						</div>
				</label></td>
			</tr>
			<tr bgcolor="#85C7FC">
				<td height="26"><div align="center">密&nbsp;&nbsp;码：</div></td>
				<td height="26"><label> <input type="password"
						name="password">
				</label></td>
			</tr>
			<tr align="center" bgcolor="#85C7FC">
				<td colspan="2"><input type="submit" value="登录" />
					&nbsp;&nbsp;&nbsp; <input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>