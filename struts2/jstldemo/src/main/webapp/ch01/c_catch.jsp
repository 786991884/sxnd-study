<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>catch标签实例</h4>
	<hr>
	<c:catch var="errors">
		<%
			String num = request.getParameter("num");
				int i = Integer.parseInt(num);
				out.print("the number is" + i);
		%>
	</c:catch>
		<c:out value="${errors }"></c:out>
</body>
</html>