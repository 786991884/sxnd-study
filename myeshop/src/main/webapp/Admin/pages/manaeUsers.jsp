<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tools.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户管理</title>
<%
	String pash = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pash + "/";
%>
<base href="<%=basePath%>">
<link href="Admin/css/body.css" rel="stylesheet" type="text/css" />
<link href="Admin/css/td_fontSize.css" rel="stylesheet" type="text/css" />
<link href="Admin/css/tab.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Admin/js/manageUsers.js"></script>
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
						<td bgcolor="#f3ffe3">
							<table width="99%" border="0" align="center" cellpadding="0"
								cellspacing="1" bgcolor="#c0de98">
								<tr>
									<th background="Admin/images/tab_14.gif" class="STYLE1">用户ID</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1">用户名</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1">性别</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1">手机</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1">地址</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1">积分</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1"><input
										type="checkbox" id="selectAll" onclick="selectAll()">全/反选</th>
									<th background="Admin/images/tab_14.gif" class="STYLE1"></th>
								</tr>
								<form method="post" name="deleteForm">
									<c:forEach var="user" items="${userList}">
										<tr align="center">
											<td bgcolor="#FFFFFF" class="STYLE2">${user.id }</td>
											<td bgcolor="#FFFFFF" class="STYLE2">${user.name }</td>
											<td bgcolor="#FFFFFF" class="STYLE2">${user.gender
												==1?'男':'女'}</td>
											<td bgcolor="#FFFFFF" class="STYLE2">${user.mobile }</td>
											<td bgcolor="#FFFFFF" class="STYLE2">${user.address }</td>
											<td bgcolor="#FFFFFF" class="STYLE2">${user.score }</td>
											<td bgcolor="#FFFFFF" class="STYLE2"><input
												type="checkbox" name="delete" value="${user.id }"></td>
											<td bgcolor="#FFFFFF" class="STYLE2"><a
												href="getOneUserServlet?id=${user.id}">详情</a></td>
										</tr>
									</c:forEach>
								</form>
							</table>
						</td>
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
									<td align="center"><pg:pager
											items="${userPager.totalNum }"
											maxPageItems="${userPager.pageSize}"
											export="currentPageNo = pageNumber" url="getUserPagerServlet">
											<pg:param name="pageSize" value="${userPager.pageSize }" />
											<pg:param name="pageNo" value="${currentPageNo}" />
											<pg:first>
												<a href="${pageUrl}"><img src="Admin/images/first.gif"
													border="0"></a>
											</pg:first>
											<pg:prev>
												<a href="${pageUrl}"><img src="Admin/images/back.gif"
													border="0" /></a>
											</pg:prev>
											<pg:pages>
												<c:choose>
													<c:when test="${userPager.pagecurrentPageNo eq pageNumber}">
														<font color="red">${pageNumber}</font>
													</c:when>
													<c:otherwise>
														<a href="${pageUrl}">${pageNumber}</a>
													</c:otherwise>
												</c:choose>
											</pg:pages>
											<pg:next>
												<a href="${pageUrl}"><img src="Admin/images/next.gif"
													border="0" /></a>
											</pg:next>
											<pg:last>
												<a href="${pageUrl}"><img src="Admin/images/last.gif"
													border="0" /></a>
											</pg:last>
										</pg:pager></td>
									<td colspan="1" align="right"><input type="button"
										value="删除"
										onclick="removeUser(${userPager.pageOffset},${userPager.pageSize})">
									</td>
									<td width="14"><img src="Admin/images/tab_22.gif"
										width="14" height="29" /></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>