<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<body>
	<p style="display: none">Hello</p>
	<script type="text/javascript">
		//显示所有段落
		$("p").show();
		//用缓慢的动画将隐藏的段落显示出来，历时600毫秒
		$("p").show("slow");
		//将隐藏的段落用将近4秒的时间显示出来。。。并在之后执行一个反馈
		$("p").show(4000, function() {
			$(this).text("Animation Done...");
			//隐藏所有段落
			$("p").hide();
			//用200毫秒将段落迅速隐藏，之后弹出一个对话框
			$("p").hide("fast", function() {
				alert("Animation Done.");
			});
		});
	</script>

</body>
</html>