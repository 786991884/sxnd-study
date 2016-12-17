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
	<!-- 创建实例 -->
	<s:bean name="bean.Student" id="stu_1">
		<s:param name="name">张三</s:param>
		<s:param name="age" value="23" />
	</s:bean>
	<!-- 使用push标签将stu_1放入ValueStack栈顶 -->
	<s:push value="#stu_1">
		<s:property value="name" />
		<s:property value="age" />
	</s:push>
</body>
</html>