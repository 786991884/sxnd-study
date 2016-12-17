<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<s:form action="/user/userLogin.action">
		<s:textfield label="First Name" name="name" />
		<s:submit value="submit" />
	</s:form>
</body>
</html>
