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
	<s:form>
		<s:doubleselect name="typelist" list="{'数据库','框架'}"
			doubleList="top=='数据库'?{'MySql','Oracle'}:
				{'struts','hibernate','spring'}"
			doubleName="courselist" />
	</s:form>
</body>
</html>