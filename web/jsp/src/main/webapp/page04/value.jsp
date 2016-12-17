<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="book" class="ch04.BookBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="book" value="jsp程序设计" />
	<jsp:setProperty property="price" name="book" value="33.3" />
	<jsp:setProperty property="recommend" name="book" value="true" />
	name:<%=book.getName()%><br> price:<%=book.getPrice()%>元
	<br>
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