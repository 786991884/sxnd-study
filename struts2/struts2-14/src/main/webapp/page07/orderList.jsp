<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书购买页</title>
</head>
<body>
	<form action="orderList.action" method="post">
		<table>
			<caption>添加图书</caption>
			<th>图书名称</th>
			<th>价格</th>
			<th>出版社</th>
			<tr>
				<td><input name="books[0].title"></td>
				<td><input name="books[0].price"></td>
				<td><input name="books[0].publisher"></td>
			</tr>
			<tr>
				<td><input name="books[1].title"></td>
				<td><input name="books[1].price"></td>
				<td><input name="books[1].publisher"></td>
			</tr>
			<tr>
				<td><input name="books[2].title"></td>
				<td><input name="books[2].price"></td>
				<td><input name="books[2].publisher"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="添加">
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>