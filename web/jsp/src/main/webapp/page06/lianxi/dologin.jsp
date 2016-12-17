<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理用户登录页面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		if (username.equals("sun") && password.equals("1234")) {
			session.setAttribute("username", "sun");
			response.sendRedirect("show.jsp");
		} else {
			request.setAttribute("errorinfo", "用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		}
	%>
</body>
</html>