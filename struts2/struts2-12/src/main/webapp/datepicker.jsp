<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sj:head jqueryui="true" jquerytheme="start" />
</head>
<body>
	<form>
		生日：
		<sj:datepicker name="birthday" id="birthday" displayFormat="yy年mm月dd日"></sj:datepicker>
		<br> 提供年和月的选择：
		<sj:datepicker name="mydate" id="mydate" changeYear="true"
			changeMonth="true" yearRange="1949:2069">
		</sj:datepicker>
	</form>
</body>
</html>