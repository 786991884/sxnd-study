<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="store" class="ch08.estore.BookStore"
	scope="application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="storeTable" scope="application">
		<center>
			<table border="1">
				<c:forEach var="book" items="${store.books }">
					<tr>
						<td>${book.value.id }</td>
						<td>${book.value.name }</td>
						<td>${book.value.price }</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</c:set>
</body>
</html>