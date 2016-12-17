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
		<div class="dropdown">
			<button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				Dropdown <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
				<li role="presentation" class="divider"></li>
				<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-default">Left</button>
			<button type="button" class="btn btn-default">Middle</button>
			<button type="button" class="btn btn-default">Right</button>
		</div>
		<div class="btn-toolbar" role="toolbar">
			<div class="btn-group">
				<button type="button" class="btn btn-default">1</button>
				<button type="button" class="btn btn-default">2</button>
				<button type="button" class="btn btn-default">3</button>
				<button type="button" class="btn btn-default">4</button>
				<button type="button" class="btn btn-default">5</button>
				<button type="button" class="btn btn-default">6</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-default">7</button>
				<button type="button" class="btn btn-default">8</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-default">9</button>
			</div>
		</div>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default">1</button>
			<button type="button" class="btn btn-default">2</button>
			<button type="button" class="btn btn-default">3</button>
			<button type="button" class="btn btn-default">4</button>
			<button type="button" class="btn btn-default">5</button>
			<button type="button" class="btn btn-default">6</button>
		</div>
		<div class="btn-group btn-group-sm">
			<button type="button" class="btn btn-default">7</button>
			<button type="button" class="btn btn-default">8</button>
		</div>
		<div class="btn-group btn-group-xs">
			<button type="button" class="btn btn-default">9</button>
		</div>

	</div>
</body>
</html>