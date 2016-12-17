<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>层次选择器</title>
<script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//匹配表单中所有的子级input元素
		//结果：<input name="name" />
		$("form>input");
		//匹配所有跟在 label后面的input元素
		//结果：<input name="name" />, <input name="newsletter" />
		$("form+input");
		//找到所有与表单同辈的 input元素
		//结果：<input name="none" />
		$("form ~ input");
	});
</script>
</head>
<body>
	<form>
		<label>Name:</label> <input name="name" value="dddd">
		<fieldset>
			<label>NewsLetter:</label> <input name="newsletter">
		</fieldset>
	</form>
	<input name="none">
</body>
</html>