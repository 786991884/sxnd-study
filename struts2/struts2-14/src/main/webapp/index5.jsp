<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>输入用户名，用户是否存在</h3>
	<s:set name="score" value="#parameters.score[0]"></s:set>
	查询 的结果是：
	<s:if test="#score==xbh">
存在
</s:if>
	<s:elseif test="#score==mrs">
存在
</s:elseif>
	<s:else>
不存在
</s:else>
</body>
</html>