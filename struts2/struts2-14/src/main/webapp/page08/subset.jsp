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
	<!-- subset截取集合的2个元素，从第3个开始截取 -->
	<s:subset source="{'JavaSE','Html','JavaScript','MySQL','JDBC'}"
		start="2" count="3">
		<ol>
			<!-- 迭代子集合，没有指定value属性值，故迭代ValueStatck栈顶的元素 -->
			<s:iterator status="i">
				<li
					<s:if test="#i.odd">style="background-color:#0fc;width:200px"</s:if>>
					<s:property />
				</li>
			</s:iterator>
		</ol>
	</s:subset>
</body>
</html>