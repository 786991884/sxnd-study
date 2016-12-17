<%@page import="com.model.TbMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	TbMessage tbMessage = (TbMessage) request.getAttribute("tbMessage");
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
<script type="text/javascript">
	function check() {
		if (form1.writer.value == "") {
			alert("留言人不能为空！");
			form1.writer.focus();
			return false;
		}
		if (form1.content.value == "") {
			alert("留言内容不能为空！");
			form1.content.focus();
			return false;
		}
		return true;
	}
</script>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改留言</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
	<table width="797" height="234" border="0" align="center"
		cellpadding="0" cellspacing="0" background="images/top.jpg">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<form name="form1" method="post" action="MessageServlet?action=update"
		onSubmit="return check();">
		<table width="797" height="340" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="210" height="368" rowspan="2"
					background="images/left.jpg">&nbsp;</td>
				<td height="290" align="center" valign="top"><table width="95%"
						height="286" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="14%"><strong>留言人：</strong></td>
							<td width="86%"><input name="writer" type="text" id="writer"
								value="<%=tbMessage.getWriter()%>"> * <input name="id"
								type="hidden" id="id" value="<%=tbMessage.getId()%>"></td>
						</tr>
						<tr>
							<td height="191"><strong>留言内容：</strong></td>
							<td><textarea name="content" cols="70" rows="9"
									class="wenbenkuang" id="content"><%=tbMessage.getContent()%></textarea>
								*</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input name="Submit" type="submit" class="btn_bg"
								value="提 交"> &nbsp;&nbsp; <input name="Submit2"
								type="reset" class="btn_bg" value="重  置"> &nbsp;&nbsp; <input
								name="Submit3" type="button" class="btn_bg" value="返  回"
								onClick="window.location.href='MessageServlet?action=list';"></td>
						</tr>
					</table></td>
				<td width="25" rowspan="2" background="images/right.jpg">&nbsp;</td>
			</tr>
			<tr>
				<td height="78" background="images/bottom.jpg">&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>