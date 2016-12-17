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
	<s:i18n name="msgResource">
		<s:form action="loginAction">
			<caption>
				<s:text name="login_title" />
			</caption>
			<s:textfield name="username" key="login_username" />
			<s:password name="password" key="login_password" />
			<s:submit key="login_submit" />
		</s:form>
	</s:i18n>
</body>
</html>
