<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>
	<tags:products>
		<jsp:attribute name="normal">
			��Ʒ:${name}<br />
			�۸�:${price}
		</jsp:attribute>
		<jsp:attribute name="onSale">
			��Ʒ:${name}<br />
			<font color="red"><strike>ԭ��:${origPrice}</strike></font>
			<br />
			�۸�:${price}
		</jsp:attribute>
	</tags:products>
</body>
</html>
