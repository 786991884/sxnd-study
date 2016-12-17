<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Say Hello</title>
</head>
<body>
	<h2>
		<center>
			hello,<%=request.getParameter("user")%><br> The values of
			parameter user are:
			<%
			String[] values = request.getParameterValues("user");
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
		%><%=values[i]%>
			<%
				}
				}
			%>
		</center>
	</h2>
</body>
</html>