<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性操作函数-值操作函数</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		alert($('img').attr("alt"));
		//清除属性
		$("img").removeAttr("height");
		//设置属性
		$("img").attr({
			"height" : "50",
			"width" : "50"
		});
		$("#single").val("Single2");
		$("#multiple").val([ "Multiple2", "Multiple3" ]);
		$("input").val([ "check1", "check2", "radio1" ]);
	});
</script>

</head>
<body>
	<img alt="电脑产品" src="computer.jpg" height="100">
	<br>
	<img alt="女士上衣" src="women.jpg" height="100">

	<br>
	<select id="single">
		<option>Single</option>
		<option>Single2</option>
	</select>
	<select id="multiple" multiple="multiple">
		<option selected="selected">Multiple</option>
		<option>Multiple2</option>
		<option selected="selected">Multiple3</option>
	</select>
	<br />
	<input type="checkbox" value="check1" /> check1
	<input type="checkbox" value="check2" /> check2
	<input type="radio" value="radio1" /> radio1
	<input type="radio" value="radio2" /> radio2
</body>
</html>