<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎用户</title>
</head>
<body>
	<h5>这是[${loginUser.name} ], 今年[${loginUser.age }],
		毕业时间是[${loginUser.graduationDate }]</h5>
</body>
</html>