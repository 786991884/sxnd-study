<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:property value="userList.class"/>
	<table>
		<tr>
			<td>Name</td>
			<td>Age</td>
		</tr>
	<s:iterator value="userList" status="sta">
	  <s:if test="#sta.odd">
	  <tr>
			<td><s:property value="name" /></td>
			<td><s:property value="age" /></td>
		</tr>
	  </s:if>
	  <s:else>
	  
	   <tr style="background-color: red;">
			<td><s:property value="name" /></td>
			<td><s:property value="age" /></td>
		</tr>
	  </s:else>
		
	</s:iterator>
	</table>
</body>
</html>