<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<title>Insert title here</title>
</head>
<body>
	<p>p1</p>
	<p id="myp2">p2</p>
	<script type="text/javascript">
		console.log($("p").get(1) === document.getElementById("myp2"));
		console.log($("p")[1] === document.getElementById("myp2"));
		console.log($("p").get()[1] === document.getElementById("myp2"));
	</script>
</body>
</html>