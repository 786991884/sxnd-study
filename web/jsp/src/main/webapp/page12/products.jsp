<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<tags:products>
		<jsp:attribute name="normal">
			商品:${name}<br />
			价格:${price}
		</jsp:attribute>
		<jsp:attribute name="onSale">
			商品:${name}<br />
			<font color="red"><strike>原价:${origPrice}</strike></font>
			<br />
			价格:${price}
		</jsp:attribute>
	</tags:products>
</body>
</html>
