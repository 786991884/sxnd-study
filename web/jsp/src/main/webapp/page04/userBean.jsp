<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="book" class="ch04.BookBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		book.setName("程序设计");
		book.setPrice(10);
		book.setRecommend(false);
	%>
	name:
	<%=book.getName()%><br /> price:<%=book.getPrice()%><br /> recommend:
	<%
		if (book.isRecommend()) {
	%>
	推荐此书!
	<%
		} else {
	%>
	不推荐此书!
	<%
		}
	%>
</body>
</html>