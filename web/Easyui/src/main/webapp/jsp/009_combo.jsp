<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/commons.js"></script>
<script type="text/javascript">
	$(function() {
		$(function() {
			$('#cc').combo({
				required : true,
				editable : false,
				width : 255,
				panelHeight : 300
			});
			$('#sp').appendTo($('#cc').combo('panel'));
			$('#sp img').click(
					function() {
						var v = $(this).attr('value');
						var s = $(this).attr('text');
						$('#cc').combo('setValue', v).combo('setText', s)
								.combo('hidePanel');
					});
		});
	});
</script>
</head>
<body>
	<select id="cc"></select>
	<div id="sp">
		<div style="color: #99BBE8; background: #fafafa; padding: 5px;">选择一张图片</div>
		<div>
			<img src="images/001.jpg" value="001.jpg" text="图片1"></img>
		</div>
		<div>
			<img src="images/002.jpg" value="002.jpg" text="图片2"></img>
		</div>
		<div>
			<img src="images/003.jpg" value="003.jpg" text="图片3"></img>
		</div>
		<div>
			<img src="images/004.jpg" value="004.jpg" text="图片4"></img>
		</div>
		<div>
			<img src="images/005.jpg" value="005.jpg" text="图片5"></img>
		</div>
	</div>
</body>
</html>