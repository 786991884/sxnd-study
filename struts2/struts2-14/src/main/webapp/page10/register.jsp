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
	<s:form action="registerAction" validate="false">
		<caption>
			<s:text name="reg_title" />
		</caption>
		<s:textfield name="bean.name" key="reg_name" />
		<s:textfield name="bean.birthday" key="reg_birthday" />
		<s:textfield name="bean.phone" key="reg_phone" />
		<s:textfield name="bean.email" key="reg_email" />
		<s:textfield name="bean.hopeJob" key="reg_hopejob" />

		<s:submit key="reg_submit" />

	</s:form>
</body>
</html>
