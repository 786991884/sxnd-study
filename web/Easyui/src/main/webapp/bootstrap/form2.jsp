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
		<div class="checkbox">
			<label> <input type="checkbox" value=""> Option one is this and that&mdash;be sure to include why it's great
			</label>
		</div>

		<div class="radio">
			<label> <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked> Option one is this and that&mdash;be sure to include why it's great
			</label>
		</div>
		<div class="radio">
			<label> <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2"> Option two can be something else and selecting it will deselect option one
			</label>
		</div>
		<label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
		</label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
		</label> <label class="checkbox-inline"> <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
		</label>
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<p class="form-control-static">email@example.com</p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword" placeholder="Password">
				</div>
			</div>
		</form>
		<div class="form-group has-success">
			<label class="control-label" for="inputSuccess">Input with success</label> <input type="text" class="form-control" id="inputSuccess">
		</div>
		<div class="form-group has-warning">
			<label class="control-label" for="inputWarning">Input with warning</label> <input type="text" class="form-control" id="inputWarning">
		</div>
		<div class="form-group has-error">
			<label class="control-label" for="inputError">Input with error</label> <input type="text" class="form-control" id="inputError">
		</div>
		<span class="help-block">自己独占一行或多行的块级帮助文本。</span>
	</div>
</body>
</html>