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
	<s:bean name="bean.Student8" id="stu_1">
		<s:param name="name">张三</s:param>
		<s:param name="age" value="23" />
	</s:bean>
	1.将Stack Context中的stu_1值放入到默认范围内
	<br />
	<s:set value="stu_1" id="def_1" />
	<hr />
	2.将Stack Context中的stu_1值放入到application范围内
	<br />
	<s:set value="stu_1" id="app_1" scope="application" />
	<hr />
	3.将Stack Context中的stu_1值放入到session范围内
	<br />
	<s:set value="stu_1" id="sess_1" scope="session" />
	<hr />
	输出结果
	<br /> 1.默认范围：
	<s:property value="#def_1.name" />
	,
	<s:property value="#def_1.age" />
	<br />
	2.application：${applicationScope.app_1.name},${applicationScope.app_1.age}
	<br /> 3.session：${sessionScope.sess_1.name },${sessionScope.sess_1.age }
	<br />
</body>
</html>