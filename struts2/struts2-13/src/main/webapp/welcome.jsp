<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转换成功</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
-->
</style>
</head>
<body>
	<p align="center" class="STYLE1">&nbsp;</p>
	<p align="center" class="STYLE1">&nbsp;</p>
	<p align="center" class="STYLE1">转换成功！</p>
	<div align="center">
		<table width="211" border="1">
			<tr>
				<td width="116" bgcolor="#FFCCFF"><div align="center">用户名：</div></td>
				<td width="79"><s:property value="name" /></td>
			</tr>
			<tr>
				<td bgcolor="#FFCCFF"><div align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</div></td>
				<td><s:property value="password" /></td>
			</tr>
			<tr>
				<td bgcolor="#FFCCFF"><div align="center">出生日期：</div></td>
				<td><s:property value="user.date" /></td>
			</tr>
		</table>
	</div>
</body>
</html>