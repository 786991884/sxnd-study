<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>${fn:toLowerCase("USA") } <br>
${fn:substring('I am student',2,4) }<br>
${fn:substringAfter('I am student','am') }<br>
${fn:replace('I am student','am','is') }<br>
<%
String[] arr={"1","2","3"};
request.setAttribute("myarr",arr );
%>
${fn:join(myarr,":") }<br>
${fn:escapeXml("<b>cc</b>") }
</body>
</html>