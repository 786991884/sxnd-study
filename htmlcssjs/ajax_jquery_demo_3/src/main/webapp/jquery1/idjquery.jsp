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
	<div id="notMe">
		<p>id="notMe"</p>
	</div>
	<div id="myDiv">id="myDiv"</div>
	<span id="foo:bar"></span>
	<span id="foo[bar]"></span>
	<span id="foo.bar"></span>
	<div>DIV1</div>
	<div>DIV2</div>
	<span>SPAN</span>
	<script type="text/javascript">
		$("#myDiv");
		$("#foo\\:bar");
		console.log($("div"));
		console.log($("*"));
	</script>
</body>
</html>