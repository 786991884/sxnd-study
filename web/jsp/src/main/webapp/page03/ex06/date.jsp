<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<center>
			hello,<%=new String(request.getParameter("user").getBytes(
					"iso-8859-1"), "utf-8")%>,
			<!-- OUT：隐含变量 -->
			<%--OUT:隐含变量 --%>
			<%
				Calendar cal = Calendar.getInstance();
				if (cal.get(Calendar.AM_PM) == Calendar.AM) {
					out.println("good morning!");
				} else {
					out.println("good afternoon!");
				}
			%>
		</center>
	</h2>
</body>
</html>