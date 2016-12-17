<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="conn" class="util.ConnDB" scope="page"></jsp:useBean>
	<ul>
		<%
			ResultSet rs = conn
					.executeQuery("SELECT title FROM tb_bbsInfo ORDER BY id DESC"); //获取公告信息
			if (rs.next()) {
				do {
					out.print("<li>" + rs.getString(1) + "</li>");
				} while (rs.next());
			} else {
				out.print("<li>暂无公告信息！</li>");
			}
		%>

	</ul>
</body>
</html>