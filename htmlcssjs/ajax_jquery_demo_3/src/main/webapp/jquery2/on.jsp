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
		$("p").on("click", function() {
			alert($(this).text());
		});
		function myHandler(event) {
			alert(event.data.foo);
		}
		$("p").on("click", {
			foo : "bar"
		}, myHandler);
		$("form").on("submit", false);
		$("form").on("submit", function(event) {
			event.preventDefault();
		});
		$("form").on("submit", function(event) {
			event.sotpPropagation();
		});
		$("p").off();
		$("p").off("click", "**");
		var foo = function() {
			$("body").on("click", "p", foo);
			$("body").off("click", "p", foo);
		};
		var validate = function() {
			$("form").on("click.validator", "button", validate);
			$("form").on("keypress.validator", "input[type='text']", validate);
			$("form").off(".validator");
		}
	</script>
</body>
</html>