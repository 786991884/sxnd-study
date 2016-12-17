<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XML Parse</title>
</head>
<body>
	<x:parse var="doc">
		<%@include file="/page09/ex04/games.xml"%>
	</x:parse>
	<table border="1">
		<tr>
			<td>$doc//sport</td>
			<td><pre>
					<x:out select="$doc//sport" />
				</pre></td>
		</tr>
		<tr>
			<td>$doc/games/country/*</td>
			<td><pre>
					<x:out select="$doc/games/country" /> </pre></td>
		</tr>
		<tr>
			<td>$doc//*</td>
			<td><pre>
					<x:out select="$doc//*" />
				</pre></td>
		</tr>
		<tr>
			<td>$doc/games/country</td>
			<td><pre>
					<x:out select="$doc/games/country" />
				</pre></td>
		</tr>
	</table>
</body>
</html>