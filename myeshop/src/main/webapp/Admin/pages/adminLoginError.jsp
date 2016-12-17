<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<title>权限不足无法访问</title>
</head>
<body>

	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="Admin/images/tab_03.gif"
							width="15" height="30" /></td>
						<td width="1101" background="Admin/images/tab_05.gif">&nbsp;</td>
						<td width="281" background="Admin/images/tab_05.gif"><table
								border="0" align="right" cellpadding="0" cellspacing="0">
								<tr>
									<td width="60"><table width="87%" border="0"
											cellpadding="0" cellspacing="0">
											<tr>
												<td class="STYLE1"><div align="center"></div></td>
												<td class="STYLE1"><div align="center"></div></td>
											</tr>
										</table></td>
									<td width="60"><table width="90%" border="0"
											cellpadding="0" cellspacing="0">
											<tr>
												<td class="STYLE1"><div align="center">
														<br>
													</div></td>
												<td class="STYLE1"></td>
											</tr>
										</table></td>
									<td width="60"><table width="90%" border="0"
											cellpadding="0" cellspacing="0">
											<tr>
												<td class="STYLE1"><div align="center">
														<br>
													</div></td>
												<td class="STYLE1"><div align="center">
														<br>
													</div></td>
											</tr>
										</table></td>
									<td width="52"><table width="88%" border="0"
											cellpadding="0" cellspacing="0">
											<tr>
												<td class="STYLE1"><div align="center">
														<br>
													</div></td>
												<td class="STYLE1"><div align="center">
														<br>
													</div></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
						<td width="14"><img src="Admin/images/tab_07.gif" width="14"
							height="30" /></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="9" background="Admin/images/tab_12.gif">&nbsp;</td>
						<td bgcolor="#f3ffe3" align="center">你无权访问该页面!</td>
						<td width="9" background="Admin/images/tab_16.gif">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="29"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="15" height="29"><img src="Admin/images/tab_20.gif"
							width="15" height="29" /></td>
						<td background="Admin/images/tab_21.gif"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="25%" height="29" nowrap="nowrap">&nbsp;</td>
									<td width="75%" valign="top" class="STYLE1">&nbsp;</td>
								</tr>
							</table></td>
						<td width="14"><img src="Admin/images/tab_22.gif" width="14"
							height="29" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>