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
	<p id="foo">单击我</p>
	<script type="text/javascript">
		//当每个段落被点击的时候，弹出其文本。
		$("#foo").bind("click", function() {
			window.alert($(this).text());
		});
		//把一个函数和一个事件之间建立联系
		$("p").bind("click", function(event) {
			alert(event);
		});
		//触发某个事件也即让某个事件发生，进而事件处理函数被调用
		$("p").trigger("click");
		//同时绑定多个事件类型
		$('#foo').bind('mouseenter mouserleave', function() {
			$(this).toggleClass('entered');
		});
		//同时绑定多个事件类型/处理程序
		$("button").bind({
			click : function() {
				$("p").slideToggle();
			},
			mouseover : function() {
				$("body").css("background-color", "red");
			},
			mouseout : function() {
				$("body").css("background-color", "#ffffff");
			}
		});
		//你可以在事件处理之前传递一些附加的数据
		function handler(event) {
			alert(event.data.foo);
		};
		$("p").bind("click", {
			foo : "bar"
		}, handler);
		//通过返回false来取消默认的行为并阻止事件起泡
		$("form").bind("submit", function() {
			return false;
		});
		//通过使用 preventDefault() 方法只取消默认的行为
		$("form").bind("submit", function(event) {
			event.preventDefault();
		});
		//通过使用 stopPropagation() 方法只阻止一个事件起泡
		$("form").bind("submit", function(event) {
			event.stopPropagation();
		});
	</script>
</body>
</html>