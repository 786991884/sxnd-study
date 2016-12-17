<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>选择所要显示的语言</h1>
	<form action="fmt.jsp" method="get">
		<select name="locale">
			<option value="zh_CN">中文</option>
			<option value="en US">English</option>
		</select> <input type="submit" value="提交">
	</form>
</body>
</html>