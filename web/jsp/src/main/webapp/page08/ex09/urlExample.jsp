<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Encode</title>
</head>
<body>
	<table border="1" bgcolor="#dddddd">
		<tr>
			<td>"urlExample.jsp",param=ABC</td>
			<td><c:url value="urlExample.jsp">
					<c:param name="param" value="ABC"></c:param>
				</c:url></td>
		</tr>
		<tr>
			<td>"urlExample.jsp", param1=123,param2=abc</td>
			<td><a
				href="
                     <c:url value="urlExample.jsp">
                          <c:param name="param1" value="123"/>
                          <c:param name="param2" value="abc"/>
                    </c:url>">urlExample.jsp</a>
			</td>
		</tr>
	</table>
</body>
</html>