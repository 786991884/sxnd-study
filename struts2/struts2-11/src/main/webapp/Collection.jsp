<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="doCollection" >
<s:textfield name="userList[0].name" label="第一个User的名字"></s:textfield>
<s:textfield name="userList[0].age" label="第一个User的年龄"></s:textfield>
<s:textfield name="userList[1].name" label="第二个User的名字"></s:textfield>
<s:textfield name="userList[1].age" label="第二个User的年龄"></s:textfield>
<s:textfield name="userList[2].name" label="第三个User的名字"></s:textfield>
<s:textfield name="userList[2].age" label="第三个User的年龄"></s:textfield>
<s:textfield name="userList[3].name" label="第四个User的名字"></s:textfield>
<s:textfield name="userList[3].age" label="第四个User的年龄"></s:textfield>
<s:submit></s:submit>
</s:form>
</body>
</html>