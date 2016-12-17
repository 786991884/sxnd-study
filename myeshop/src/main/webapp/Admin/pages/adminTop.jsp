<%@page import="com.Admin.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'adminTop.jsp' starting page</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Admin admin = (Admin) session.getAttribute("admin");
	String name = "";
	if (admin != null) {
		name = admin.getName();
	}
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="Admin/js/adminTop.js"></script>
<link href="Admin/css/adminTop.css" rel="stylesheet" type="text/css" />


</head>

<body onload="showTime">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="table-layout: fixed;">
		<tr>
			<td height="9"
				style="line-height: 9px; background-image: url(Admin/images/main_04.gif)"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="97" height="9" background="Admin/images/main_01.gif">&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="47" background="Admin/images/main_09.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="38" height="47" background="Admin/images/main_06.gif">&nbsp;</td>
						<td width="59"><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td height="29" background="Admin/images/main_07.gif">&nbsp;</td>
								</tr>
								<tr>
									<td height="18" background="Admin/images/main_14.gif"><table
											width="100%" border="0" cellspacing="0" cellpadding="0"
											style="table-layout: fixed;">
											<tr>
												<td style="width: 1px;">&nbsp;</td>
												<td><span class="STYLE1"><%=name%></span></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
						<td width="155" background="Admin/images/main_08.gif">&nbsp;</td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td height="23" valign="bottom"><img
										src="Admin/images/main_12.gif" width="367" height="23"
										border="0" usemap="#Map" /></td>
								</tr>
							</table></td>
						<td width="200" background="Admin/images/main_11.gif"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="11%" height="23">&nbsp;</td>
									<td width="89%" valign="bottom"><span class="STYLE1"
										id="timeId"></span></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="5"
				style="line-height: 5px; background-image: url(Admin/images/main_18.gif)"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="180" background="Admin/images/main_16.gif"
							style="line-height: 5px;">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
	</table>

	<map name="Map" id="Map">
		<area shape="rect" coords="3,1,49,22"
			href="Admin/pages/adminConter.jsp" />
		<area shape="rect" coords="52,1,95,21" onclick="window.history.go(-1)" />
		<area shape="rect" coords="102,1,144,21"
			onclick="window.history.go(1)" />
		<area shape="rect" coords="150,1,197,22" href="#"
			onclick="window.history.go(0)" />
		<area shape="rect" coords="210,1,304,20"
			href="Admin/pages/updatePassword.jsp" target="contentIframe" />
		<area shape="rect" coords="314,1,361,23"
			href="Admin/login/adminlogin.jsp" />
	</map>
</body>
</html>