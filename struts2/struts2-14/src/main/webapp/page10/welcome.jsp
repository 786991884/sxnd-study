<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<ol>
		<li>${requestScope.message}</li>
		<li><s:text name="login_welcome">
				<s:param>
					<s:property value="username" />
				</s:param>
			</s:text></li>
	</ol>
</body>
</html>

