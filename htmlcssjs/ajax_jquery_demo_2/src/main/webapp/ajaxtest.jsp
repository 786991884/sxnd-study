<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
	<input type="button" onclick="getInnerText()" value="单击">
	<p id="myp"></p>
	<script type="text/javascript">
		function show() {
			$
					.ajax({
						global : true,
						type : 'post',
						url : "control",
						data : {
							method : 'show',
						},
						success : function(data) {
							var divNode = $("#divs");
							divNode.html("");
							if (data != "null") {
								var o = eval("(" + data + ")");
								var title = $("<div>");
								title
										.html("|<span>编号</span>|<span>姓名</span>|<span>心情</span>|<span>发布时间</span>|");
								title.appendTo(divNode);
								$.each(o, function(i, n) {
									var div = $("<div>");
									var span = "|"
									$.each(n, function(pro, val) {
										span = span + "<span>" + val
												+ "</span>|";
									})
									div.html(span).appendTo(divNode);
								})
								divNode.show();
							} else {
								$("#msg").html("没有数据信息");
							}
						}
					});
		}
		function getInnerText() {
			$.get("getInnerText", {
				name : "z3",
				age : "23"
			}, function(data) {
				document.getElementById("myp").innerHTML = data;
			}, "text");
			$.ajax({
				type : "get",
				url : "getInnerText",
				data : {
					name : "z3",
					age : "23"
				},
				//只有成功了都会被调用
				//readystate=4 and status=200时调用
				success : function(data) {
					document.getElementById("myp").innerHTML = data;
				},
				//失败时间调用 
				error : function() {
					document.getElementById("myp").innerHTML = "错误页面";
				},
				beforeSend : function(xhr) {
					console.log("xhr=" + xhr);
				},
				//成功或者失败函数都会被调用
				complete : function() {
					console.log("调用complete");
				},
				dataType : "text"
			});
		}
	</script>
</body>
</html>