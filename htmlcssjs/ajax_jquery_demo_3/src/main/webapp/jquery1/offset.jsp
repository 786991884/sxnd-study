<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		var p = $("p:last");
		var offset = p.offset();
		//把所有段落的高设为30
		var height = $("p").height(30);
		//以10像素的幅度增加p元素的高度
		$("button").click(function() {
			$("p").height(function(n, c) {
				return c + 10;
			});
		});
		/*p.html("left:" + offset.left + ",top:" + offset.top);
		 $("p:last").offset({
			top : 10,
			left : 30
		}); 
		 */
	});
</script>
</head>
<body>
	<p>Hello</p>
	<p>徐冰浩</p>
	<input type="button" value="增加高度" >
</body>
</html>