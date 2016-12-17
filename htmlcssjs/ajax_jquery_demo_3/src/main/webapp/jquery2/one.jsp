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
</head>
<body>
	<script type="text/javascript">
		//当所有段落被第一次点击的时候，显示所有其文本
		$("p").one("click", function() {
			alert($(this).text());
		});
		//提交第一个表单，但不用submit()
		$("form:first").trigger("submit");
		//给一个事件传递参数
		$("p").click(function(event, a, b) {
			// 一个普通的点击事件时，a和b是undefined类型
			// 如果用下面的语句触发，那么a指向"foo",而b指向"bar"
		}).trigger("click", [ "foo", "bar" ]);
		//如果你对一个focus事件执行了 .triggerHandler() ，浏览器默认动作将不会被触发，只会触发你绑定的动作
		$("p").bind("myEvent", function(event, message1, message2) {
			alert(message1 + '' + message2);
		});
		$("p").trigger("myEvent", [ "hello", "world" ]);
	</script>
</body>
</html>