<%@page import="entity.Notice"%>
<%@page import="biz.NoticeServcice" %>
<%@page import="biz.impl.NoticeServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Customer"%>
<%@ page import="entity.Product"%>
<%@ page import="biz.ProdService"%>
<%@ page import="biz.impl.ProdServiceImpl"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	request.setCharacterEncoding("utf-8");
	Customer cust = (Customer) session.getAttribute("cust");
	String custname = "";
	if (cust != null) {
		custname = cust.getCustname();
	}

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//这个id是通过index页面传过来的  id=product.getProdid()
	String prodId = request.getParameter("id");
	String prodName = "";
	String prodImg = "";
	String putawayTime = "";
	double prodPrice = 0.0;
	ProdService prodService = new ProdServiceImpl();
	Product product = prodService.getProductById(prodId);
	if (product != null) {
		prodName = product.getProdname();
		prodImg = product.getProdimg();
		putawayTime = product.getPutawaytime() == null ? "" : df
				.format(product.getPutawaytime());
		prodPrice = product.getProdprice();
	}
	//第一次来到这个页面时，其值为空，当将商品加入购物车之后就不为空了
	String count = (String) session.getAttribute("count");

	NoticeServcice noticeService = new NoticeServiceImpl();
	List noticeList = noticeService.getNotice();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品详情</title>
<link href="style/css.css" rel="stylesheet" type="text/css" />
<link href="style/div.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		//点击放入购物车时触发该函数，也就是说每点击一次该值就会传递一次
			function toListCart(){
				var obj =document.getElementById("selectCountk");
				var index=obj.options[obj.selectedIndex].value;
				//将prodId传给listCart页面
				var url="listCart.jsp?prodId=<%=prodId%>
	&index=" + index;
		var aa = window.showModalDialog(url, null,
				"DialogWidth:650px;DialogHeight:350px");
		if (aa) {
			window.location = "confirm.jsp";
		} else {
			window.location = "index.jsp";
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
			<div id="left">
				<div id="notice_title">
					系统公告 <img src="images/1119.gif" width="29" height="5" />
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
				<div>
					<div align="left" style="float: left;">
						<img src='<%=prodImg%>' width="305" height="325" />
					</div>
					<div align="left">
						<br> &nbsp;&nbsp; <strong><font size="5" style=""><%=prodName%></font>
						</strong> <br /> <br /> &nbsp;&nbsp;&nbsp;上架时间：<%=putawayTime%><br />
						<br /> &nbsp;&nbsp;&nbsp;商品号：(<%=prodId%>) <br /> <br />
						&nbsp;&nbsp;&nbsp; <font size="6" color="red">￥<%=prodPrice%></font>
						<br /> &nbsp;&nbsp;&nbsp;用户评价： <img alt="红星"
							src="images/1142.gif" width=14 height=15 align='absmiddle'
							border=0> <img alt="红星" src="images/1142.gif" width=14
							height=15 align='absmiddle' border=0> <img alt="红星"
							src="images/1142.gif" width=14 height=15 align='absmiddle'
							border=0> <img alt="红星" src="images/1142.gif" width=14
							height=15 align='absmiddle' border=0> <img alt="红星"
							src="images/1142.gif" width=14 height=15 align='absmiddle'
							border=0> <br /> &nbsp;&nbsp;
						<hr width="260px">
						<br /> &nbsp;&nbsp;&nbsp;数量：&nbsp;
						<!-- 如何得到input的输入值？？？？？，，然后将其传给listCart页面，加到count上 -->
						<select style="width: 50px" id="selectCountk" name="select">
							<option value='1'>1</option>
							<option value='2'>2</option>
							<option value='3'>3</option>
							<option value='4'>4</option>
							<option value='5'>5</option>
							<option value='6'>6</option>
						</select> <br /> <br /> <br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
							src="images/1141.gif" onclick="toListCart()">
					</div>
					<br /> <br /> <br /> <br /> <br /> <br />
				</div>
				<div id="new_title" align="left">支付方式</div>
				<br />
				<div align="left">
					<p>本网站为客户提供在线支付、货到付款、邮政汇款等多种支付方式，可满足您不同的支付需求。</p>
					<ul>
						<li><br /> <b>1. 在线支付</b> <br />
							本网站已开通&ldquo;支付宝&rdquo;、&ldquo;网上银行&rdquo;、&ldquo;银联&rdquo;等多家在线支付方式，
							支持包括招商银行在内的所有已开通网银功能的银行卡，可实时到帐。进行网上在线支付前，请确认您的银行卡
							是否开通网上在线支付功能。使用在线支付的顾客可享受优先发货的服务。</li>
						<li><br /> <b>2. 信用卡支付</b> <br />
							请提供信用卡号、有效期及身份证号，在您确认订单后，即可实时向发卡行申请授权(信用卡支付不支持第三方收货)。 <br /> <img
							src="images/1143.gif" /></li>
						<li><br /> <b>3. 货到付款</b> <br />
							货到付款支持现金支付和移动POS刷卡支付两种方式，系统会自动根据您的收货地址提供可选择的支付方式。 <br />
							注：货到付款无需收取额外手续费，货到付款金额低于15元将不能享受此支付方式。</li>
						<li><b>温馨提示：</b> <br /> 1. 以上支付方式是目前顾客在购物中最常见的支付方式。 <br />
							2. 其他支付方式请登录&ldquo;<a
							style="color: rgb(171, 0, 54); text-decoration: underline;"
							href="">帮助中心</a>&rdquo;查看。</li>
					</ul>
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
