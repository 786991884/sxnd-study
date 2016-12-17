<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String strName = request.getParameter("strName");
	System.out.println("客户姓名：" + strName);
	int iRandom = (int) (Math.random() * 10);
	System.out.println("随机数：" + iRandom);

	if (iRandom % 2 == 1) {
		out.print("yes");
	} else if (iRandom % 2 == 0) {
		out.print("no");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>