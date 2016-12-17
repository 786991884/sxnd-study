<%@page import="ch04.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BookBean book = null;
		book = new BookBean();
		book.setName("程序设计");
		book.setPrice(20);
		book.setRecommend(false);
	%>
	name:<%=book.getName()%><br> price:<%=book.getPrice()%><br>
	recommand:
	<%
		if (book.isRecommend()) {
	%>
	推荐此书！
	<%
		} else {
	%>
	不推荐此书！
	<%
		}
	%>
</body>
</html>