<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<html>
<head>
<title>XML Tags</title>
</head>
<body>
	<x:parse var="doc">
		<%@include file="/page09/ex04/games.xml"%>
	</x:parse>
	<table border="1">
		<x:forEach var="country" select="$doc//country">
			<tr>
				<th><x:out select="$country/@id" /></th>
				<td>
					<table border="1">
						<tr>
							<th>Name</th>
							<th>Sport</th>
							<th>Age</th>
							<th>Gener</th>
						</tr>
						<x:forEach var="athlete" select="$country/athlete">
							<tr>
								<td><x:out select="$athlete/name" /></td>
								<td><x:out select="$athlete/sport" /></td>
								<td><x:out select="$athlete/age" /></td>
								<td><x:out select="$athlete/gender" /></td>
							</tr>
						</x:forEach>
					</table>
				</td>
			</tr>
		</x:forEach>
	</table>
</body>
</html>
