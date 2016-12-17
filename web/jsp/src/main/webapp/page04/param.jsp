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
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="book" class="ch04.BookBean" scope="session"></jsp:useBean>
	<%--	<jsp:setProperty property="name" name="book" param="name" />
	<jsp:setProperty property="price" name="book"/> --%>
	<jsp:setProperty property="name" name="book"  />
	<jsp:setProperty property="price" name="book"  />
	<%--<jsp:setProperty property="*" name="book"/>--%>
	<%--书名：<%=book.getName()%><br> 价格：<%=book.getPrice()%>元--%>
	书名：<jsp:getProperty property="name" name="book" /><br> 价格：<jsp:getProperty
		property="price" name="book" />元
	<br>
	<%--推荐：<jsp:getProperty name="book" property="recommend" />--%>
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
	%><br>
</body>
</html>