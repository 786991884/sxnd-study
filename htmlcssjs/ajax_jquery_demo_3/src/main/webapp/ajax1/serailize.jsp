<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
	<p id="results">
		<b>Results: </b>
	</p>
	<form>
		<select name="single">
			<option>Single</option>
			<option>Single2</option>
		</select> <select name="multiple" multiple="multiple">
			<option selected="selected">Multiple</option>
			<option>Multiple2</option>
			<option selected="selected">Multiple3</option>
		</select><br /> <input type="checkbox" name="check" value="check1" /> check1 <input
			type="checkbox" name="check" value="check2" checked="checked" />
		check2 <input type="radio" name="radio" value="radio1"
			checked="checked" /> radio1 <input type="radio" name="radio"
			value="radio2" /> radio2
	</form>
	<script type="text/javascript">
		$("#results").append("<tt>" + $("form").serialize() + "</tt>");
	</script>
</body>
</html>