<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page errorPage="errorStudent.jsp"%>
<jsp:useBean id="act" class="ch05.student.Action" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="act" />
<jsp:useBean id="stu" class="ch05.student.Student" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="stu" />
<jsp:forward page="modifyStudent.jsp"></jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>