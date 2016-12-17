<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<button type="button" class="btn btn-default">Default</button>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-link">链接</button>
		<p>
			<button type="button" class="btn btn-primary btn-lg">Large button</button>
			<button type="button" class="btn btn-default btn-lg">Large button</button>
		</p>
		<p>
			<button type="button" class="btn btn-primary">Default button</button>
			<button type="button" class="btn btn-default">Default button</button>
		</p>
		<p>
			<button type="button" class="btn btn-primary btn-sm">Small button</button>
			<button type="button" class="btn btn-default btn-sm">Small button</button>
		</p>
		<p>
			<button type="button" class="btn btn-primary btn-xs">Extra small button</button>
			<button type="button" class="btn btn-default btn-xs">Extra small button</button>
		</p>
		<a class="btn btn-default" href="#" role="button">Link</a>
		<button class="btn btn-default" type="submit">Button</button>
		<input class="btn btn-default" type="button" value="Input"> <input class="btn btn-default" type="submit" value="Submit">

	</div>
</body>
</html>