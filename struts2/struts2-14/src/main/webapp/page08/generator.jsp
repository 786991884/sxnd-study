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
	<!-- 使用generator将一个字符串解析成集合 -->
	<s:generator val="'JavaSE,JavaEE,JavaME'" separator=",">
		<ol>
			<s:iterator status="i">
				<li
					<s:if test="#i.odd">style="background-color:#00ffcc;width:200px"</s:if>>
					<s:property />
				</li>
			</s:iterator>
		</ol>
	</s:generator>
</body>
</html>