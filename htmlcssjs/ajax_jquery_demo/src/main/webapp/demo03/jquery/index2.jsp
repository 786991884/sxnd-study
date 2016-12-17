<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性选择器</title>
<style type="text/css">
body {
	font-size: 12px;
	text-align: center;
}

div {
	float: left;
	border: solid 1px #ccc;
	margin: 8px;
	width: 65px;
	height: 65px;
	display: none;
}
</style>
<script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//显示所有含有id属性的元素
		$("[id]").show(3000);
		//显示所有属性title的值是imoracle的元素
		$("[title='imoracle']").show(3000);
		//显示所有属性title的值不是imoracle的元素
		$("[title!='imoracle']").show(3000);
		//显示所有属性title的值以"im"开始的元素
		$("[title^='im']").show(3000);
		//显示所有属性title的值以"wdp"结束的元素
		$("[title$='wdp']").show(3000);
		//显示所有属性title的值中含有"oracle"的元素
		$("[title*='oracle']").show(3000);
		//显示所有属性title的值中含有"oracle"且属性id的值是"oracleWDP"的元素
		$("[id='oracleWDP'][title*='oracle']").show(3000);
	});
</script>
</head>
<body>
	<div id="oracle">我的ID是oracle</div>
	<div title="imoracle">我的title是imoracle</div>
	<div id="oracleWDP" title="imoraclewdp">
		我的ID是oracleWDP<br>我的titile是imoraclewdp
	</div>
	<div title="imoraclewdp">我的title是imoraclewdp</div>
</body>
</html>