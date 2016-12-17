<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriplet Sample</title>
</head>
<body>
	<h2>
		Display weekdays in Chinese:<br>
		<%
			DateFormatSymbols zhdfs = new DateFormatSymbols(Locale.CHINA);
			String[] zhWeekDays = zhdfs.getWeekdays();
			for (int i = 1; i < zhWeekDays.length; i++) {
				out.println(zhWeekDays[i] + "<br>");
			}
		%>
		Display weekdays in English:<br>
		<%
			DateFormatSymbols endfs = new DateFormatSymbols(Locale.ENGLISH);
			String[] enWeekDays = endfs.getWeekdays();
			for (int i = 1; i < enWeekDays.length; i++) {
				out.println(enWeekDays[i] + "<br>");
			}
		%>
	</h2>
</body>
</html>