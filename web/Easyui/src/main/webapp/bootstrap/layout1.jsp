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
		<div class="row">
			<h1>Hello, world!</h1>
			<div class="col-xs-4">
				<h2 class="page-header">区域一</h2>
				<p>Bootstrap has a few easy ways to quickly get started, each one appealing to a different skill level and use case. Read through to see what suits your particular needs.</p>
			</div>
			<div class="col-xs-4">
				<h2 class="page-header">区域二</h2>
				<p>If you work with Bootstrap's uncompiled source code, you need to compile the LESS files to produce usable CSS files. For compiling LESS files into CSS, we only officially support Recess, which is Twitter's CSS hinter based on less.js.</p>
			</div>
			<div class="col-xs-4">
				<h2 class="page-header">区域三</h2>
				<p>Within the download you'll find the following directories and files, logically grouping common resources and providing both compiled and minified variations.</p>
			</div>
		</div>
		<abbr title="attribute">attr</abbr> <abbr title="HyperText Markup Language" class="initialism">HTML</abbr>
		<blockquote>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
		</blockquote>
		<blockquote>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
			<small>Someone famous in <cite title="Source Title">Source Title</cite></small>
		</blockquote>
		<ul class="list-inline">
			<li>Lorem ipsum dolor sit amet</li>
			<li>Lorem ipsum dolor sit amet</li>
			<li>Lorem ipsum dolor sit amet</li>
			<li>Lorem ipsum dolor sit amet</li>
			<li>Lorem ipsum dolor sit amet</li>
		</ul>
		<dl>
			<dt>.Lorem ipsum dolor sit amet</dt>
			<dd>Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet</dd>
		</dl>

	</div>
</body>
</html>