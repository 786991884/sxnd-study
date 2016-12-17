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
		<div class="container">
			<table class="table table-striped table-bordered table-hover table-condensed table-responsive">
				<caption>Table</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>User Name</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>1</td>
						<td>aehyok</td>
						<td>leo</td>
						<td>@aehyok</td>
					</tr>
					<tr class="success">
						<td>2</td>
						<td>lynn</td>
						<td>thl</td>
						<td>@lynn</td>
					</tr>
					<tr class="warning">
						<td>3</td>
						<td>Amdy</td>
						<td>Amy</td>
						<td>@Amdy</td>
					</tr>
					<tr class="danger">
						<td>4</td>
						<td>Amdy</td>
						<td>Amy</td>
						<td>@Amdy</td>
					</tr>
					<tr>
						<td class="success">5</td>
						<td class="danger">Amdy</td>
						<td class="warning">Amy</td>
						<td class="active">@Amdy</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>