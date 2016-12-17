<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="param.jsp" method="post">
		书名：<input type="text" name="name" value=""><br> 价格： <input
			type="text" name="price" value="">元 <br> 推荐： <select
			name="recommend">
			<option value="true">是</option>
			<option value="fales">否</option>
		</select> <br> <input type="submit" value="提交">
	</form>
</body>
</html>