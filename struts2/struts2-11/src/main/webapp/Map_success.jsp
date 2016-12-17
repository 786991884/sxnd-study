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
<s:property value="userMap.class"/>
	<table>
		<tr>
			<td>Name</td>
			<td>Age</td>
		</tr>
		<!-- map迭代时每项是Map.Entry类型，该类型有getKey()和getValue -->
	<s:iterator value="userMap" status="sta">
	  <s:if test="#sta.odd">
	  <tr>
			<td><s:property value="value.name" /></td>
			<td><s:property value="value.age" /></td>
		</tr>
	  </s:if>
	  <s:else>
	  
	   <tr style="background-color: red;">
			<td><s:property value="value.name" /></td>
			<td><s:property value="value.age" /></td>
		</tr>
	  </s:else>
		
	</s:iterator>
	</table>
</body>
</html>