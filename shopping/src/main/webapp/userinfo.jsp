<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Customer"%>
<%
	response.setContentType("text/html;charset=utf-8");
	Customer cust = (Customer) session.getAttribute("cust");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户基本信息页面</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var username = document.getElementById("username").value;
		var gender = document.getElementById("gender").value;
		var address = document.getElementById("address");
		if (username == "") {
			alert("请填写您的真实姓名！");
			return false;
		} else if (gender == "") {
			alert("请填写你的性别！");
			return false;
		} else if (adderss == "") {
			alert("请填写您的邮递地址！");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="main">
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
		<br> <br> <br> <br>
		<div id="left">
			<div id="notice_title">
				网站公告 <img src="images/1119.gif" width="29" height="5" />
			</div>
			<div id="notice">
				<span><img src="images/1120.gif" width="27" height="14" />30日前在本网站购物的用户</span>
				<br /> <img src="images/1121.gif" width="27" height="14" />
				4月25-28日狂欢购物节！ <br /> <img src="images/1121.gif" width="27"
					height="14" /> 购物满500元送精美礼品！ <br /> <img src="images/1121.gif"
					width="27" height="14" /> 知名运动品牌底价促销 <br /> <img
					src="images/1120.gif" width="27" height="14" /> 网站最新改版上线 <br /> <img
					src="images/1120.gif" width="27" height="14" /> 关于网站抽奖的说明
			</div>
			<div id="event">
				<img src="images/1122.gif" width="200" height="95" /> <img
					src="images/1123.gif" width="200" height="93" />
			</div>
			<div id="time">
				<img src="images/1124.gif" width="188" height="75" /> <img
					src="images/1125.gif" width="188" height="98" />
			</div>
			<div id="pic">
				<img src="images/1126.gif" width="200" height="50" />
			</div>
		</div>

		<div id="right">
			<font color="6C415C" size="5">个人信息修改</font> <br> <br>
			<hr>
			<br> 恭喜您成为会员！请完整填写以下个人信息（<font color="red">*</font> 为必填） <br>
			<br> <br>
			<form action="RegisterServlet" onsubmit="return check()">
				<table>
					<tr>
						<td height="40" align="left"><font style="font-size: 12px">邮件：</font>
						</td>
						<td><span style="font-size: 12px"><%=cust != null ? cust.getLoginid() : ""%></span>
						</td>
					</tr>
					<tr>
						<td height="40" align="left"><font style="font-size: 12px">真实姓名：</font>
						</td>
						<td><input name="username" type="text" class="mytext">&nbsp;
							<font color="red">*</font></td>
					</tr>
					<tr>
						<td height="40" align="left"><font style="font-size: 12px">性别：</font>
						</td>
						<td><input name="gender" type="text" class="mytext">&nbsp;
							<font color="red">*</font></td>
					</tr>
					<tr>
						<td height="40" align="left"><font style="font-size: 12px">联系地址：</font>
						</td>
						<td><input name="address" type="text" class="mytext" />&nbsp;
							<font color="red">*</font> <font style="font-size: 12px">为能精确配送，请详细录入街道/路段</font>
						</td>
					</tr>
					<tr>
						<td height="40" align="left"><font style="font-size: 12px">手机：</font>
						</td>
						<td><span style="font-size: 12px"><%=cust != null ? cust.getTel() : ""%></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" height="30"><input
							name="button" type="submit" value="保  存" /></td>
					</tr>
				</table>
				<input type="hidden" name="type" value="modify" /> <input
					type="hidden" name="email"
					value='<%=cust != null ? cust.getLoginid() : ""%>' /> <input
					type="hidden" name="phone"
					value='<%=cust != null ? cust.getTel() : ""%>' />
			</form>
			<br> <br> <br>
			<hr>
			<font style="font-size: 12px" color="red">如需修改邮箱和手机号请联系客服：02-399-0000，感谢您的支持！</font>
		</div>
		<div id="link">
			<span>关于我们</span><span>版权声明</span><span>联系我们</span><span>网站声明</span><span>来购联盟</span>
		</div>
		<div id="bottom">
			<img src="images/1139.gif" width="125" height="69" /> <br />
			COPYRIGHT (C) 2004-2007 DUTYFREE24 DONGWHA.All Rights Reserved.
		</div>
	</div>
</body>
</html>
