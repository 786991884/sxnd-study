<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<<jsp:useBean id="act" class="ch05.student.Action" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Error Information</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Error</td>
			<td><%=exception.toString()%></td>
		</tr>
		<tr>
			<td>Operation</td>
			<td><%=act.getAction()%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="<%=act.getResource()%>">Try
					again</a></td>
		</tr>
	</table>
</body>
</html>