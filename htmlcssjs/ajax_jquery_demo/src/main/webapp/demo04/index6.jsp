<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表格背景（样式操作函数）</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<style type="text/css">
.row {
	background-color: #cccccc;
}
</style>
<script type="text/javascript">
	$(function() {
		$("th").addClass("row");
		$("th").removeClass("row");
		$("tr:gt(0):even").css("background-color", "#cccccc");
	});
</script>

</head>
<body>
	<table border="1">
		<caption>商品数量统计</caption>
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>当前库存</th>
		</tr>
		<tr>
			<td>1</td>
			<td>ThinkPad笔记本</td>
			<td>122</td>
		</tr>
		<tr>
			<td>2</td>
			<td>dell台式机</td>
			<td>200</td>
		</tr>
		<tr>
			<td>3</td>
			<td>罗技鼠标</td>
			<td>122</td>
		</tr>
		<tr>
			<td>4</td>
			<td>漫步者音箱</td>
			<td>200</td>
		</tr>
	</table>
</body>
</html>