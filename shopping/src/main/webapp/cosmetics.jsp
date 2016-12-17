<%@page import="biz.impl.NoticeServiceImpl"%>
<%@page import="entity.Notice"%>
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

	ProdServiceImpl prodService = new ProdServiceImpl();
	List prodList = prodService.getProdByType("cosmetics");
	String count = (String) session.getAttribute("count");

	NoticeServiceImpl noticeService = new NoticeServiceImpl();
	List noticeList = noticeService.getNotice();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品分类</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function submit() {
		var a = document.getElementById("a");
	}
</script>
</head>

<body>
	<div id="box" align="center" style="width: 1200">
		<div id="logo" align="center">
			<a href="index.jsp"><img src="images/1108.gif" width="144"
				height="28" /></a>
		</div>
		<div id="top_link">
			<%
				if (cust != null) {
			%>
			您好，<%=custname%>
			<%
				} else {
			%>
			<a href="login.jsp">登录</a>&nbsp;|&nbsp;<a href="register.jsp">注册</a>
			<%
				}
			%>
			&nbsp;|&nbsp;会员中心&nbsp;|&nbsp;帮助中心
			<%
				if (count != null) {
			%>
			&nbsp;|&nbsp;<a href="confirm.jsp">购物车(<%=count%>)
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
				height="15" /></a> <a href="bag.jsp"><img src="images/1110.gif"
				width="65" height="15" /></a> <a href="watch.jsp"><img
				src="images/1111.gif" width="65" height="15" /></a> <a
				href="fashion.jsp"><img src="images/1112.gif" width="65"
				height="15" /></a> <img src="images/1113.gif" width="65" height="15" />
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
			<div id="left">
				<div id="notice_title">
					网站公告 <img src="images/1119.gif" width="29" height="5" />
				</div>
				<div id="notice" align="left">
					<%
						if (noticeList != null) {
							for (int i = 0; i < noticeList.size(); i++) {
								Notice notice = (Notice) noticeList.get(i);
								String message = notice.getMessage();
								if (message.length() > 12) {
									message = message.substring(0, 12);
								}
					%>
					<span><img src="images/1120.gif" width="27" height="14" />&nbsp;<%=message%></span>
					<br />
					<%
						}
						}
					%>
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
				<div id="new_title">化妆品</div>
				<%
					if (prodList != null) {
						for (int i = 0; i < prodList.size(); i++) {
							Product product = (Product) prodList.get(i);
							//Map prodMap=(Map)prodList.get(i);
							String id = product.getProdid();
							String prodName = product.getProdname();
							String prodPrice = String.valueOf(product.getProdprice());
							String prodImg = product.getProdimg();
				%>
				<div id="new2">
					<a href="details.jsp?id=<%=id%>"><img src="<%=prodImg%>"
						width="128" height="108" /></a> <br /> <span id="a" class="font01"><%=prodName%></span>
					<br />
					<%=prodPrice%>
				</div>
				<%
					}
					}
				%>
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
