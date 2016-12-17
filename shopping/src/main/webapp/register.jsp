<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册页面</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function check() {
		var email = document.getElementById("email").value;
		var phone = document.getElementById("phone").value;
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		if (email == "") {
			alert("密码不能为空!");
			return false;
		} else if (email.indexOf("@") < 0 && email.indexOf(".") < 0) {
			alert("邮箱格式不正确!");
			return false;
		} else if (phone == "") {
			alert("手机号不能为空！");
			return false;
		} else if (phone.length != 11 || !isMobil(phone)) {
			alert("请输入正确的手机号码！");
			return false;
		} else if (password == "") {
			alert("密码不能为空！");
			return false;
		} else if (repassword == "") {
			alert("确认密码不能为空！");
			return false;
		} else if (password != repassword) {
			alert("两次输入密码不一致，请重新输入！");
			return false;
		}
	}

	//手机号码验证信息
	function isMobil(s) {
		var patrn = /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
		if (!patrn.exec(s)) {
			return false;
		}
		return true;
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
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="6C415C"
			size="5">新用户注册</font> <br>
		<hr width="400" align="center">
		<br>
		<form action="RegisterServlet" onsubmit="return check()">
			<table width="480" height="212">
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">输入邮箱
					</font></td>
					<td>&nbsp;&nbsp; <input name="email" type="text"
						class="mytext" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">输入手机号</font>
					</td>
					<td>&nbsp;&nbsp; <input name="phone" type="text"
						class="mytext" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">设置密码</font>
					</td>
					<td>&nbsp;&nbsp; <input name="password" type="password"
						class="mytext">
					</td>
				</tr>
				<tr>
					<td height="30" align="right"><font style="font-size: 12px">确认密码</font>
					</td>
					<td>&nbsp;&nbsp; <input name="repassword" type="password"
						class="mytext">
					</td>
				</tr>
				<tr>
					<td height="48" colspan="2" align="center"><input
						type="submit" name="button" value="注  册" /></td>
				</tr>
			</table>
			<input type="hidden" name="type" value="register" />
		</form>
	</div>
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
