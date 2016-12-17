<%@ attribute name="tbcolor"%>
<%@ attribute name="title"%>
<%@ attribute name="tdcolor"%>

<table border="1" bgcolor="${tbcolor}">
	<tr><td><b>${title}</b></td></tr>
	<tr><td bgcolor="${tdcolor}">
		<jsp:doBody/>
	</td></tr>
</table>