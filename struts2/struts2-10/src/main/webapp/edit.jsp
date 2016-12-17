<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<s:head />
</head>
<body>
	<h1></h1>
	<s:form action="edit">
		<s:textfield key="personBean.lastName"></s:textfield>
		<s:textfield key="personBean.firstName"></s:textfield>
		<s:select list="sports" key="personBean.sport"></s:select>
		<s:radio list="genders" key="personBean.gender"></s:radio>
		<!-- listKey就是生成的option的value值，也是选中后提交的值 
		listValue:是用户看到的修值不会提交到服务器-->
		<s:select list="states" listKey="stateAbbr" listValue="stateName"
			key="personBean.residency"></s:select>
		<s:checkbox key="personBean.over21"></s:checkbox>
		<s:checkboxlist list="carModelAvailable" key="personBean.carModels"></s:checkboxlist>
		<s:submit value="sava changes"></s:submit>
	</s:form>
</body>
</html>