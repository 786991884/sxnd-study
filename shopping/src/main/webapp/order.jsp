<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Customer"%>
<%@ page import="entity.Product"%>
<%@ page import="biz.impl.ProdServiceImpl"%>
<%
	request.setCharacterEncoding("utf-8");
	Customer cust = (Customer) session.getAttribute("cust");
	String custname = "";
	if (cust != null) {
		custname = cust.getCustname();
	}

	String price = request.getParameter("price");
	String count = (String) session.getAttribute("count");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>结算页面</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	color: #999999
}
-->
</style>
<script type="text/javascript">
	function check() {
		var consignee = document.getElementById("consignee").value;
		var phone = document.getElementById("phone").value;
		var orderaddress = document.getElementById("orderaddress").value;
		var zipcode = document.getElementById("zipcode").value;
		if (consignee == "") {
			alert("收货人不能为空!");
			return false;
		} else if (orderaddress == "") {
			alert("收货地址不能为空！");
			return false;
		} else if (zipcode == "") {
			alert("邮政编码不能为空！");
			return false;
		} else if (phone == "") {
			alert("手机号不能为空！");
			return false;
		} else if (phone.length != 11 || !isMobil(phone)) {
			alert("请输入正确的手机号码！");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="box" align="center" style="width: 1200">
		<div id="logo" align="center">
			<a href="index.jsp"><img src="images/1108.gif" width="144"
				height="28" /> </a>
		</div>
		<div id="top_link">
			<%
				if (cust != null) {
			%>
			您好，<%=custname%>
			<%
				} else {
			%>
			<a href="login.jsp">登录</a>&nbsp;|&nbsp; <a href="register.jsp">注册</a>
			<%
				}
			%>
			&nbsp;|&nbsp;会员中心&nbsp;|&nbsp;帮助中心
			<%
				if (count != null) {
			%>
			&nbsp;|&nbsp; <a href="confirm.jsp">购物车(<%=count%>)
			</a>
			<%
				} else {
			%>
			&nbsp;|&nbsp;购物车
			<%
				}
			%>
		</div>

		<div id="menu">
			<a href="cosmetics.jsp"><img src="images/1109.gif" width="65"
				height="15" /> </a> <a href="bag.jsp"><img src="images/1110.gif"
				width="65" height="15" /> </a> <a href="watch.jsp"><img
				src="images/1111.gif" width="65" height="15" /> </a> <a
				href="fashion.jsp"><img src="images/1112.gif" width="65"
				height="15" /> </a> <img src="images/1113.gif" width="65" height="15" />
			<img src="images/1114.gif" width="65" height="15" /> <img
				src="images/1115.gif" width="65" height="15" />
		</div>
		<div id="main">
			<div id="flash" align="left">
				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
					codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
					width="251" height="227">
					<param name="movie" value="images/pop.swf" />
					<param name="quality" value="high" />
					<embed src="images/pop.swf" quality="high"
						pluginspage="http://www.macromedia.com/go/getflashplayer"
						type="application/x-shockwave-flash" width="251" height="227"></embed>
				</object>
			</div>
			<div id="banner">
				<div id="banner1">
					<img src="images/1116.gif" width="570" height="100" />
				</div>
				<div id="banner2">
					<img src="images/1117.gif" width="255" height="78" /> <img
						src="images/1118.gif" width="255" height="78" />
				</div>
			</div>
			<div id="line"></div>
			<div style="width: 800px; height: 400px">
				<div align="left">
					<p>
						<img src="images/shoppingtitle2.gif">
					</p>
					<br />
				</div>
				<div style="border: #e2dfdf solid 1px;" align="left">
					<br /> <strong><font size="3">&nbsp;&nbsp;收货人信息</font> </strong>
					<hr color="#e2dfdf" style="border: 1px" align="center" width="770">
					<form action="OrderServlet" onsubmit="return check()">
						<table width="760" height="178" style="font-size: 12">
							<tr>
								<td width="105" align="right"><font color="red">*</font>收 货
									人：</td>
								<td width="643"><input name="consignee" type="text"
									class="text2" /> &nbsp; <span class="style1">请输入收货人姓名</span></td>
							</tr>
							<tr>
								<td align="right"><font color="red">*</font>详细地址：</td>
								<td><input name="orderaddress" type="text" class="text2" />
									&nbsp; <span class="style1">地址须包括省市区县及详细路名与门牌号等信息，否则可能会使您无法收到商品</span>
								</td>
							</tr>
							<tr>
								<td align="right"><font color="red">*</font>邮政编码：</td>
								<td><input name="zipcode" type="text" class="text2" />
									&nbsp; <span class="style1">请填写准确的邮编，错误邮编可能会使您无法收到购买商品</span></td>
							</tr>
							<tr>
								<td align="right"><font color="red">*</font>联系电话：</td>
								<td><input name="phone" type="text" class="text2" />
									&nbsp; <span class="style1">用于发送进度通知，接收短信完全免费</span></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="submit"
									class="mySubmit" value="" /></td>
							</tr>

						</table>
						<input type="hidden" name="orderprice" value="<%=price%>" />
					</form>
				</div>
			</div>
			<div id="link">
				<span>关于我们</span><span>版权声明</span><span>联系我们</span><span>网站声明</span><span>来购联盟</span>
			</div>
			<div id="bottom">
				<img src="images/1139.gif" width="125" height="69" /> <br />
				COPYRIGHT (C) 2004-2007 DUTYFREE24 DONGWHA.All Rights Reserved.
			</div>
		</div>
	</div>
</body>
</html>
