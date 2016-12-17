<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>parse和out标签实例</h1>
	<c:import var="docString" url="games.xml"></c:import>
	<x:parse var="doc" doc="${docString }"></x:parse>
	<table border="1">
		<tr>
			<td valign="top"><pre>
					<c:out value="${docString }"></c:out>
				</pre></td>
			<td valign="top">
				<table border="1">
					<tr>
						<th>XPath表达式</th>
						<th>查找到的元素</th>
					</tr>
					<tr>
						<td>$doc//sport</td>
						<td><pre>
								<x:out select="$doc//sport" />
							</pre></td>
					</tr>
					<tr>
						<td>$doc/games/country/*</td>
						<td><pre>
								<x:out select="$doc/games/country" />
							</pre></td>
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
					<tr>
						<td>$doc/games/country[last()]</td>
						<td><pre>
								<x:out select="$doc/games/country[last()]" />
							</pre></td>
					</tr>
					<tr>
						<td>$doc//country[@id='Denmark']</td>
						<td><pre>
								<x:out select="$doc//country[@id='Denmark']" />
							</pre></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
</body>
</html>