<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功显示页面</title>
</head>
<body>
	<%
		if (session.getAttribute("username") == null) {
			request.setAttribute("errorinfo", "请先登录！");
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	%>
	欢迎!<%=session.getAttribute("username")%>
</body>
</html>