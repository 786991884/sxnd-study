<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<jsp:useBean id="stu" class="ch05.student.Student" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify Student Information</title>
</head>
<body>
	Student self-management system. Please modify your information:
	<br />
	<table>
		<form action="updateStudent.jsp" method="GET">
			<input type="hidden" name="action" value="modify" /> <input
				type="hidden" name="resource" value="modifyStudent.jsp" />
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value="<jsp:getProperty name='stu' property='name'/>" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"
					value="<jsp:getProperty name='stu' property='age'/>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Modify" /></td>
			</tr>
		</form>
	</table>
</body>
</html>