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
		<div class="input-group">
			<span class="input-group-addon">@</span> <input type="text" class="form-control" placeholder="Username">
		</div>

		<div class="input-group">
			<input type="text" class="form-control"> <span class="input-group-addon">.00</span>
		</div>

		<div class="input-group">
			<span class="input-group-addon">$</span> <input type="text" class="form-control"> <span class="input-group-addon">.00</span>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox">
					</span> <input type="text" class="form-control">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="radio">
					</span> <input type="text" class="form-control">
				</div>
			</div>
		</div>

	</div>
</body>
</html>