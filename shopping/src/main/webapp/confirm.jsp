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
    //得到要删除的商品编号？？？删除商品待解决
    String deleteProdID=request.getParameter("deleteProdID")==null?"":request.getParameter("deleteProdID");
	//prodList、 count的值是在listCart页面放进去的
    List prodList = (List) session.getAttribute("prodList");
	String count=(String)session.getAttribute("count");
	int number=0;
	if(count!=null && count!=""){
		number=Integer.parseInt(count);
	}
	if(!"".equals(deleteProdID)){
		number=number-1;
		count=String.valueOf(number);
		//其值改变后再次放入session中
		session.setAttribute("count",count);
	}
	//pList中放的是product，prodList2中放的是prodId（根据prodId找到对应product放入pList）
	List pList = new ArrayList();
	List prodList2=new ArrayList();
	String prodId = "";
	double price = 0.0;
	//prodList=new ArrayList();
	for (int i = 0; i < prodList.size(); i++) {
		prodId = (String) prodList.get(i);
		if(!deleteProdID.equals(prodId)|| "".equals(deleteProdID)){
	ProdServiceImpl prodService = new ProdServiceImpl();
	Product product = prodService.getProductById(prodId);
	pList.add(product);
	prodList2.add(prodId);
		}
	}
	session.removeAttribute("prodList");
	//重新将商品列表的id放入prodList，并放在session中
	session.setAttribute("prodList",prodList2);
	session.setAttribute("pList", pList);
	
	
	
	
	//测试
	List indexs=(ArrayList)session.getAttribute("indexs");
	
	 System.out.println("index："+indexs);
//	 int mount=0;
	// mount=mount+input;
	// session.setAttribute("mount", mount);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>结算页面</title>
		<link href="style/css.css" rel="stylesheet" type="text/css" />
		<link href="style/div.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="style/jquery-1.4.2.min.js"></script>
		<script type="text/javascript">
			/* function calculate(c){
				//得到数量？？？（数量问题待解决）
				var count=document.getElementById("count"+c).value;
				//得到单价
				var unitprice=document.getElementById("unitprice"+c).innerText;
				unitprice=unitprice.substring(1,unitprice.length);
				//单价*数量
				var money=unitprice*count;
				//金额=单价*数量
				document.getElementById("totalPrice"+c).innerText="￥"+money;
				//商品金额总计
				var price=document.getElementById("price").innerText;
				price=price.substring(1,price.length);
				price=price+money;
			
				
			} */
			
			function deleteProd(d){
				document.getElementById("price").innerHTML="";
				var prodid=document.getElementById("prodId"+d).value;
				window.location.href="confirm.jsp?deleteProdID="+prodid;
				
				 
			}
			
			function goShoping(){
				window.location.href="index.jsp";
			}
			
			function confirm(){
				var custname="<%=custname%>";
				//商品金额总计
				var price=document.getElementById("price").innerText;
				//显示商品信息的form表单
				var param=$("#paramform").serialize(); 
				param=encodeURI(param);
				price=price.substring(1,price.length);
				if(custname==""){
					window.location.href="login.jsp?isConfirm=OK";
				}else{
					window.location.href="order.jsp?price="+price;
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
				<%if(cust != null){
					%>
					 您好，<%=custname %>
					<%
				}else{
				 %>
				 	<a href="login.jsp">登录</a>&nbsp;|&nbsp;<a href="register.jsp">注册</a>
				 <%
				 }
				  %>
					 &nbsp;|&nbsp;会员中心&nbsp;|&nbsp;帮助中心
				 <% 
				 if(count!=null){
				 %>
				 	&nbsp;|&nbsp;<a href="confirm.jsp">购物车(<%=count%>)</a>
				 <%}else{ %>
				 	&nbsp;|&nbsp;购物车
				 <%} %>
			</div>

			<div id="menu">
				<a href="cosmetics.jsp"><img src="images/1109.gif" width="65"
						height="15" /> </a>
				<a href="bag.jsp"><img src="images/1110.gif" width="65"
						height="15" /> </a>
				<a href="watch.jsp"><img src="images/1111.gif" width="65"
						height="15" /> </a>
				<a href="fashion.jsp"><img src="images/1112.gif" width="65"
						height="15" /> </a>
				<img src="images/1113.gif" width="65" height="15" />
				<img src="images/1114.gif" width="65" height="15" />
				<img src="images/1115.gif" width="65" height="15" />
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
						<img src="images/1117.gif" width="255" height="78" />
						<img src="images/1118.gif" width="255" height="78" />
					</div>
				</div>
				<div id="line"></div>
				<div style="width: 800px; height: 686px">
					<div align="left">
						<p>
							<img src="images/shoppingtitle.gif">
						</p>
						<br />
					</div>
					<div id="mytable" style="width: 800px">
						<form id="paramform" name="paramform">
						<table width="100%" height="141" align="left" cellpadding="1"
							cellspacing="1" bgcolor="#CCCCCC">
							<tr bordercolor="#999999" bgcolor="#EFEFEF">
								<td width="23%" height="28" align="center">
									<font size="2">商品</font>
								</td>
								<td width="30%" align="center">
									<font size="2">商品名称</font>
								</td>
								<td width="13%" align="center">
									<font size="2">单价</font>
								</td>
								<td width="12%" align="center">
									<font size="2">数量</font>
								</td>
								<td width="11%" align="center">
									<font size="2">金额</font>
								</td>
								<td width="11%" align="center">
									<font size="2">操作</font>
								</td>
							</tr>
							<%
							
							List money=(List)session.getAttribute("orderprice");
							if(money==null){
								money=new ArrayList();
							}
							
							
							
							
								if (pList.size() > 0) {
									
									
									Map products=null;
									for (int i = 0; i < pList.size(); i++) {
									
										int input=(Integer)indexs.get(i);
										
										System.out.println("indexs.size="+indexs.size()+"  选择的值"+input);
										
										Product product = (Product) pList.get(i);
										
										String prodid=(String)prodList2.get(i);
										//String prodid=product.getProdid();
										//??
										System.out.println("prodid="+prodid);
										 
										
										String prodName = product.getProdname();
										System.out.println("prodName="+prodName);
									//	String prodPrice = String.valueOf(product.getProdprice());
										double prodPrice=product.getProdprice();
										String prodImg = product.getProdimg();
										//在这里price会累加
										price = Double.valueOf(prodPrice) + price;
							%>
							<tr bgcolor="#FFFFFF" style="font-size: 12">
								<td align="center">
									<img src="<%=prodImg%>" width="128" height="108" class="style1" />
								</td>
								<td align="center">
									<%=prodName%>
								</td>
								<!-- 单价 -->
								<td align="center" id="unitprice<%=i+1 %>">
									￥<%=prodPrice%>
								</td>
								<!-- 数量   和选择的购买数量相关？？？-->
								<td align="center">
								
									<input type="text" class="text1" id="count<%=i+1 %>" value="<%=input %>"
										style="width: 40px" onblur="calculate('<%=i+1%>')"/>
								</td>
								<!-- 金额=单价*数量？？？ -->
								<td align="center" id="totalPrice<%=i +1%>">
									￥<%=prodPrice*input%>
									<%
									
									money.add(prodPrice*input);
									
									 
									%>
								</td>
								<td align="center">
									<span onclick="deleteProd('<%=i+1%>')"><a href="#">删除</a></span>
									<input type="hidden" id="prodId<%=i+1 %>" value="<%=prodid %>" />
								</td>
							</tr>
							<%
								}
								}
								String p=null;
								double p3=0;
								 session.setAttribute("orderprice", money);
								for(int j=0;j<money.size();j++){
									System.out.println("循环money:"+money.get(j));
									System.out.println("  长度："+money.size());
									 p=(money.get(j).toString());
									double p2=Double.parseDouble(p);
									 p3=p3+p2;
								}
								// double p=Double.parseDouble(p2);
							%>
							
							<tr bgcolor="#FFFFFF" style="font-size: 12">
								<td colspan="6" align="right" height="28">
									商品数量总计：<font color="red"><%=count%></font>
									商品金额总计：<span id="price" style="color: red">￥<%=p3%></span>&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						</form>
					</div>
					<div align="right">
						<br/><br/>
						<img src="images/nextshop.gif" onclick="goShoping()">
						&nbsp;&nbsp;&nbsp;
						<img src="images/goshop.gif" onclick="confirm()">
					</div>
				</div>
				<div id="link">
					<span>关于我们</span><span>版权声明</span><span>联系我们</span><span>网站声明</span><span>来购联盟</span>
				</div>
				<div id="bottom">
					<img src="images/1139.gif" width="125" height="69" />
					<br />
					COPYRIGHT (C) 2004-2007 DUTYFREE24 DONGWHA.All Rights Reserved.
				</div>
			</div>
		</div>
	</body>
</html>
