<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="normal" fragment="true" %>
<%@ attribute name="onSale" fragment="true" %>
<%@ variable name-given="name"%>
<%@ variable name-given="price"%>
<%@ variable name-given="origPrice"%>

<table border="1">
	<tr>
		<td>
			<c:set var="name" value="MP3"/>
			<c:set var="price" value="$500.0"/>
			<jsp:invoke fragment="normal"/>	
		</td>
		<td>
			<c:set var="name" value="iphone4 8G"/>
			<c:set var="origPrice" value="$3800.0"/>
			<c:set var="price" value="$3000.0"/>
			<jsp:invoke fragment="onSale"/>	
		</td>
		<td>
			<c:set var="name" value="iphone5 16G"/>
			<c:set var="price" value="$5000.0"/>
			<jsp:invoke fragment="normal"/>
		</td>
		<td>
			<c:set var="name" value="ipad2"/>
			<c:set var="price" value="$1200.0"/>
			<jsp:invoke fragment="normal"/>
		</td>
		<td>
			<c:set var="name" value="Thinkpad"/>
			<c:set var="origPrice" value="$2000.0"/>
			<c:set var="price" value="$1800.0"/>
			<jsp:invoke fragment="onSale"/>
		</td>
	</tr>
</table>