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
		<form role="form">
			<div class="form-group">
				<label for="exampleInputEmail">Email Address</label> <input class="form-control" id="exampleInputEmail" type="email" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label for="examplePassword">Email Address</label> <input class="form-control" id="examplePassword" type="password" placeholder="password">
			</div>
			<div class="form-group">
				<label for="exampleFile">File input</label> <input id="exampleFile" type="file">
				<p>Example block-level help text here.</p>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox">check me
				</label>
			</div>
			<button class="btn btn-default" type="submit">Submit</button>
		</form>
		第二个表单
		<form class="form-inline" role="form">
			<div class="form-group">
				<label class="sr-only" for="exampleInputEmail2">Email address</label> <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label class="sr-only" for="exampleInputPassword2">Password</label> <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-default">Sign in</button>
		</form>
		第三个表单
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Sign in</button>
				</div>
			</div>
		</form>
		<h1>textarea</h1>
		<textarea class="form-control" rows="3"></textarea>

	</div>
</body>
</html>