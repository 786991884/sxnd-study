<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="store" class="ch08.estore.BookStore"></jsp:useBean>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" bordercolor="pink">
		<tr>
			<c:forEach var="entry" items="${store.books}" varStatus="status">
				<td bordercolor="blue">
					<table>
						<tr>
							<td>ID</td>
							<td>${entry.value.id}</td>
						</tr>
						<tr>
							<td>Name</td>
							<td>${entry.value.name}</td>
						</tr>
						<tr>
							<td>Price</td>
							<td>${entry.value.price}</td>
						</tr>
					</table>
				</td>
				<c:if test="${ status.count mod 3 eq 0 }">
		</tr>
		<tr>
			</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>