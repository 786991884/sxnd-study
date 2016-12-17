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
	<!-- 使用append标签将两个集合拼接成新的集合，新集合的名字是newCollection -->
	<s:append id="newCollection">
		<s:param value="{'Struts','Spring','Hibernate'}" />
		<s:param value="{'JDBC','JSP','MySQL'}" />
	</s:append>
	<ol>
		<!-- 迭代新集合 -->
		<s:iterator value="#newCollection" status="i">
			<!-- <li <s:if test="#i.odd">style="background-color:#00ffcc;width:200px"</s:if>>
			<s:property />
		</li> -->
			<li><s:property /></li>
		</s:iterator>
	</ol>
</body>
</html>