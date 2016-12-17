<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="silver">
	<h1>货币</h1>
	<fmt:setLocale value="zh_CN" />
	<fmt:formatNumber value="20000" type="currency"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="20000" type="currency"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_GB" />
	<fmt:formatNumber value="20000" type="currency"></fmt:formatNumber>
	<br>
	<h2>数字</h2>
	<fmt:setLocale value="zh_CN" />
	<fmt:formatNumber value="20000" type="number"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="20000" type="number"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_GB" />
	<fmt:formatNumber value="20000" type="number"></fmt:formatNumber>
	<br>
	<h2>百分比</h2>
	<fmt:setLocale value="zh_CN" />
	<fmt:formatNumber value="20000" type="percent"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="20000" type="percent"></fmt:formatNumber>
	<br>
	<fmt:setLocale value="en_GB" />
	<fmt:formatNumber value="20000" type="percent"></fmt:formatNumber>
	<br>
	<h1>日期格式化</h1>
	<fmt:setLocale value="zh_CN" />
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<fmt:formatDate value="${now }" /><br>
	<fmt:formatDate value="${now }" type="both" /><br>
	<fmt:formatDate value="${now }" type="both"
		pattern="yyyy年MM月dd日 hh:mm:ss" /><br>

</body>
</html>