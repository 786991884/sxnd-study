<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作用域</title>
</head>
<body>
	<%
		if (application.getAttribute("applicationCount") == null) {
			application.setAttribute("applicationCount", 1);
		} else {
			Integer applicationCount = (Integer) application
					.getAttribute("applicationCount");
			applicationCount++;
			application.setAttribute("applicationCount", applicationCount);
		}
		if (session.getAttribute("sessionCount") == null) {
			session.setAttribute("sessionCount", 1);
		} else {
			Integer sessionCount = (Integer) session
					.getAttribute("sessionCount");
			sessionCount++;
			session.setAttribute("sessionCount", sessionCount);
		}
		if (request.getAttribute("requestCount") == null) {
			request.setAttribute("requestCount", 1);
		} else {
			Integer requestCount = (Integer) request
					.getAttribute("requestCount");
			requestCount++;
			request.setAttribute("requestCount", requestCount);
		}
		if (pageContext.getAttribute("pageCount") == null) {
			pageContext.setAttribute("pageCount", 1);
		} else {
			Integer pageCount = (Integer) pageContext
					.getAttribute("pageCount");
			pageCount++;
			pageContext.setAttribute("pageCount", pageCount);
		}
	%>
	applicationCount=<%=application.getAttribute("applicationCount")%><br>
	sessionCount=<%=session.getAttribute("sessionCount")%><br>
	requestCount=<%=request.getAttribute("requestCount")%><br>
	pageCount=<%=pageContext.getAttribute("pageCount")%><br>
</body>
</html>