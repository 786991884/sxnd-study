<%@page import="com.model.TbMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<TbMessage> list = (List<TbMessage>) request
			.getAttribute("listMessage");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表留言</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
	<table width="797" height="234" border="0" align="center"
		cellpadding="0" cellspacing="0" background="images/top.jpg">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="797" height="340" border="0" align="center"
		cellpadding="0" cellspacing="0">
		<tr>
			<td width="210" height="368" rowspan="2" background="images/left.jpg">&nbsp;</td>
			<td height="290" align="center" valign="top"><table width="100%"
					border="0" cellpadding="0" cellspacing="1" bgcolor="#C7A46A">
					<tr>
						<td width="11%" height="27" align="center" bgcolor="#FFFFFF">留言人</td>
						<td width="81%" align="center" bgcolor="#FFFFFF">留言内容</td>
						<td width="8%" align="center" bgcolor="#FFFFFF">修改</td>
					</tr>
					<%
						for (int i = 0; i < list.size(); i++) {
							TbMessage m = (TbMessage) list.get(i);
					%>
					<tr>
						<td height="27" bgcolor="#FFFFFF">&nbsp;<%=m.getWriter()%></td>
						<td bgcolor="#FFFFFF">&nbsp;<%=m.getContent()%></td>
						<td bgcolor="#FFFFFF">&nbsp;<a
							href="MessageServlet?action=getMessage&id=<%=m.getId()%>">修改</a></td>
					</tr>
					<%
						}
					%>
				</table></td>
			<td width="25" rowspan="2" background="images/right.jpg">&nbsp;</td>
		</tr>
		<tr>
			<td height="78" background="images/bottom.jpg">&nbsp;</td>
		</tr>
	</table>
</body>
</html>