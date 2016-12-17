<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:set name="month" value="9" />
	<s:if test="#month>9">
		第四季度
	</s:if>
	<s:elseif test="#month>6">
		第三季度
	</s:elseif>
	<s:elseif test="#month>3">
		第二季度
	</s:elseif>
	<s:else>
		第一季度
	</s:else>
</body>
</html>