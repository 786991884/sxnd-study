<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	//这个proid是detail页面传过来的，input也是
	String prodId = request.getParameter("prodId");
	String input = request.getParameter("index");
	int index = Integer.parseInt(input);
	//将input放入集合中,集合中的值类型为int
	List indexs = (List) session.getAttribute("indexs");
	if (indexs == null) {
		indexs = new ArrayList();
	}

	indexs.add(index);
	session.setAttribute("indexs", indexs);
	//这一步是为了将选择的数量转换为int型，这样就能够与number相加了

	//将index也放入session中，

	//现在prodId、input都能够正确得到其值了
	System.out.println("prodid:" + prodId + "  input:" + input);
	//这样写可以创建一个prodList对象
	List prodList = (List) session.getAttribute("prodList");
	if (prodList == null) {
		prodList = new ArrayList();
	}
	//每添加一种商品（不论数量多少，因为其proid是相同的）proidList就会加1，proid通过detail页面传过来（不为空），因此prodList也就不为空
	prodList.add(prodId);
	System.out.println("prodList:" + prodList.size());
	//第一次时，count为null，在第19行number增长，这样在第20行count的值就不是空了，然后再把它的值放到session中，这样以后的页面或servlet就可以取到它的值了
	String count = (String) session.getAttribute("count");
	int number = 0;
	if (count != null && count != "") {
		number = Integer.parseInt(count);
	}
	//此处number加上选择要购买的数量
	number = number + index;
	//而count是购物车中商品的总数量
	count = String.valueOf(number);
	//从上面来看，prodList不为空，把它放到session中，这样以后的页面或servlet中就可以取到它的值了
	session.setAttribute("prodList", prodList);
	//count的值增长后有放到session中
	session.setAttribute("count", count);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车</title>
<script type="text/javascript">
	function windowclose() {
		window.close();
		window.returnValue = "";
	}

	function confirm() {
		window.close();
		window.returnValue = "ok";
	}
</script>
</head>
<body>
	<div align="center" style="width: 600">
		<div align="center">
			<table>
				<tr>
					<td><img src="images/shopingCart.gif" width="100" height="80">
					</td>
					<td><br /> &nbsp;&nbsp; <strong>该商品已成功放入购物车</strong> <br />
						<br /> &nbsp;&nbsp;购物车共<%=number%>件商品</td>
				</tr>
			</table>
		</div>
		<div>
			<br /> <img src="images/nextshop.gif" onclick="windowclose()">
			&nbsp;&nbsp;&nbsp; <img src="images/goshop.gif" onclick="confirm()">
		</div>
	</div>
</body>
</html>
