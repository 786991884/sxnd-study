<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link href="Admin/css/admin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="Admin/js/admin.js"></script>
</head>
<body>
	<jsp:include flush="true" page="adminTop.jsp"></jsp:include>
	<div id="container">
		<div id="middle">
			<div id="left-column">
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageUserDown.jpg"
						onMouseDown="manageUser(this)" />
					<div id="manageUser" style="display: none;">
						<ul>
							<li><a href="getUserPagerServlet" target="contentIframe"
								style="text-decoration: none;">普通用户</a></li>
							<li><a href="getMerchantPagerServlet" target="contentIframe"
								style="text-decoration: none;">第三方商户</a></li>
						</ul>
					</div>
				</div>
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageOrderDown.jpg"
						onMouseDown="manageOrder(this)" />
					<div id="manageOrder" style="display: none;">

						<ul>
							<li><a href="getOrderPagerServlet" target="contentIframe"
								style="text-decoration: none;">查看所有订单</a></li>
							<li><a href="getOrderNotSendPagerServlet"
								target="contentIframe" style="text-decoration: none;">未发货订单</a></li>
							<li><a href="getOrderSendPagerServlet"
								target="contentIframe" style="text-decoration: none;">已发货订单</a></li>
							<li><a href="getOrderFreezePagerServlet"
								target="contentIframe" style="text-decoration: none;">已完成订单</a></li>
						</ul>
					</div>
				</div>
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageProductDown.jpg"
						onMouseDown="manageProduct(this)" />
					<div id="manageProduct" style="display: none;">
						<ul>
							<li><a href="Admin/controller/superTypeController.jsp"
								target="contentIframe" style="text-decoration: none;">添加大类</a></li>
							<li><a href="Admin/controller/subTypeController.jsp"
								target="contentIframe" style="text-decoration: none;">添加小类</a></li>
							<li><a href="Admin/controller/attributeController.jsp"
								target="contentIframe" style="text-decoration: none;">添加属性</a></li>
							<li><a href="Admin/controller/brandController.jsp"
								target="contentIframe" style="text-decoration: none;">添加品牌</a></li>
							<li><a href="Admin/pages/addProduct.jsp"
								target="contentIframe" style="text-decoration: none;">添加商品</a></li>
							<li><a href="getProdPagerServlet" target="contentIframe"
								style="text-decoration: none;">查看商品</a></li>
						</ul>
					</div>
				</div>
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageInformDown.jpg"
						onMouseDown="manageInform(this)" />
					<div id="manageInform" style="display: none;">
						<ul>
							<li><a href="Admin/pages/addNotice.jsp"
								target="contentIframe" style="text-decoration: none;">添加公告</a></li>
							<li><a href="getNoticePagerServlet" target="contentIframe"
								style="text-decoration: none;">查看公告</a></li>
							<li><a href="Admin/pages/addAD.jsp" target="contentIframe"
								style="text-decoration: none;">添加广告</a></li>
							<li><a href="getADPagerServlet" target="contentIframe"
								style="text-decoration: none;">查看广告</a></li>
						</ul>
					</div>
				</div>
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageLiuyanDown.jpg"
						onMouseDown="manageLiuyan(this)" />
					<div id="manageLiuyan" style="display: none;">
						<ul>
							<li><a href="getCommentPagerServlet" target="contentIframe"
								style="text-decoration: none;">查看评论</a></li>
						</ul>
					</div>
				</div>
				<div class="left-column-box">
					<img class="left-column-title"
						src="Admin/images/manageLiuyanDown.jpg"
						onMouseDown="manageMessage(this)" />
					<div id="manageMessage" style="display: none;">
						<ul>
							<li><a href="qq/jsp/admin.jsp" target="contentIframe"
								style="text-decoration: none;">消息</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="content"
				style="background-image: url(Admin/pages/beijing.jpg)">
				<iframe name="contentIframe" scrolling="auto" frameborder="0"
					width="100%" height="100%"></iframe>
			</div>
		</div>
		<div id="footer">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="24" background="Admin/images/main_47.gif"><table
							width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="29" height="24"><img
									src="Admin/images/main_45.gif" width="29" height="24" /></td>
								<td><table width="100%" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td width="369"><span class="STYLE1"> </span></td>
											<td width="814" class="STYLE1">&nbsp;</td>
											<td width="185" nowrap="nowrap" class="STYLE1"><div
													align="center">
													<img src="Admin/images/main_51.gif" width="12" height="12" />
												</div></td>
										</tr>
									</table></td>
								<td width="14"><img src="Admin/images/main_49.gif"
									width="14" height="24" /></td>
							</tr>
						</table></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>