<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String isConfirm = request.getParameter("isConfirm");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录页面</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var loginid = document.getElementById("userid").value;
		var password = document.getElementById("password").value;
		if (loginid == "") {
			alert("请输入手机号或邮箱！");
			return false;
		} else if (password == "") {
			alert("请输入密码！");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="logo" align="center">
		<img src="images/1108.gif" width="144" height="28" />
	</div>
	<div id="top_link">
		<a href="login.jsp">登录</a><span>|</span><a href="register.jsp">注册</a><span>|</span>会员中心
		<span>|</span>帮助中心 <span>|</span>购物车
	</div>
	<div id="menu">
		<img src="images/1109.gif" width="65" height="15" /> <img
			src="images/1110.gif" width="65" height="15" /> <img
			src="images/1111.gif" width="65" height="15" /> <img
			src="images/1112.gif" width="65" height="15" /> <img
			src="images/1113.gif" width="65" height="15" /> <img
			src="images/1114.gif" width="65" height="15" /> <img
			src="images/1115.gif" width="65" height="15" />
	</div>
	<br>
	<br>
	<br>
	<br>
	<div style="width: 500">
		&nbsp;&nbsp;&nbsp;&nbsp; <font color="6C415C" size="5">用户登录</font> <br>
		<hr width="400" align="left">
		<br>
		<form id="loginForm" action="LoginServlet" method="post"
			onsubmit="return check()">
			<table width="321" height="118">
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">手机号/邮箱</font>
					</td>
					<td>&nbsp;&nbsp;<input name="userid" type="text"
						class="mytext" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">密码</font>
					</td>
					<td>&nbsp;&nbsp;<input name="password" type="password"
						class="mytext">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="30"><input
						name="button" type="submit" value="登  录" /></td>
				</tr>
			</table>
			<input type="hidden" name="isConfirm" value="<%=isConfirm%>" />
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="link">
		<span>关于我们</span><span>版权声明</span><span>联系我们</span><span>网站声明</span><span>来购联盟</span>
	</div>
	<div id="bottom" style="margin-bottom: 50">
		<img src="images/1139.gif" width="125" height="69" /> <br />
		COPYRIGHT (C) 2004-2007 DUTYFREE24 DONGWHA.All Rights Reserved.
	</div>
</body>
</html>
