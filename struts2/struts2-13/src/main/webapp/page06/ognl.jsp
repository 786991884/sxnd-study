<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OGNL</title>
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
</head>
<body>
	<table width="400" border="1">
		<caption>访问Struts2命名对象</caption>
		<tr>
			<th width="300">OGNL表达式</th>
			<th width="100">值</th>
		</tr>
		<tr>
			<td>#request.person</td>
			<td><s:property value="#request.person" /></td>
		</tr>
		<tr>
			<td>#session.person</td>
			<td><s:property value="#session.person" /></td>
		</tr>
		<tr>
			<td>#application.person</td>
			<td><s:property value="#application.person" /></td>
		</tr>
		<tr>
			<td>#attr.person</td>
			<td><s:property value="#attr.person" /></td>
		</tr>
	</table>
	<br />
	<table width="400" border="1">
		<caption>访问列表</caption>
		<tr>
			<th width="300">OGNL</th>
			<th width="100">值</th>
		</tr>
		<tr>
			<td>persons[0].name</td>
			<td><s:property value="persons[0].name" /></td>
		</tr>
		<tr>
			<td>persons[1].address</td>
			<td><s:property value="persons[1].address" /></td>
		</tr>
		<tr>
			<td>persons[2].address.city</td>
			<td><s:property value="persons[2].address.city" /></td>
		</tr>
		<tr>
			<td>persons.size</td>
			<td><s:property value="persons.size" /></td>
		</tr>
		<tr>
			<td>persons.isEmpty</td>
			<td><s:property value="persons.isEmpty" /></td>
		</tr>
	</table>
	<br />
	<table width="400" border="1">
		<caption>访问Map</caption>
		<tr>
			<th width="300">OGNL</th>
			<th width="100">值</th>
		</tr>
		<tr>
			<td>persons[0].accounts['card1']</td>
			<td><s:property value="persons[0].accounts['card1']" /></td>
		</tr>
		<tr>
			<td>persons[1].accounts.card1</td>
			<td><s:property value="persons[1].accounts.card1" /></td>
		</tr>
		<tr>
			<td>persons[1].accounts.size</td>
			<td><s:property value="persons[1].accounts.size" /></td>
		</tr>
		<tr>
			<td>persons[1].accounts.isEmpty</td>
			<td><s:property value="persons[1].accounts.isEmpty" /></td>
		</tr>
	</table>
	<br />
	<table width="400" border="1">
		<caption>选择和投影</caption>
		<tr>
			<th>OGNL</th>
			<th>值</th>
		</tr>
		<tr>
			<td>persons.{?#this.age &gt; 21}</td>
			<td>
				<ul>
					<!-- 使用iterator标签迭代集合中的元素 -->
					<s:iterator value="persons.{?#this.age>21}">
						<li><s:property value="name" />的年龄为: <s:property value="age" />
						</li>
					</s:iterator>
				</ul>
			</td>
		</tr>
		<tr>
			<td>persons.{name}</td>
			<td>
				<ul>
					<!-- 使用iterator标签迭代集合中的元素 -->
					<s:iterator value="persons.{name}">
						<li><s:property /></li>
					</s:iterator>
				</ul>
			</td>
		</tr>
	</table>
	<br />
	<table width="450" border="1">
		<caption>Lambda</caption>
		<tr>
			<th>OGNL</th>
			<th>值</th>
		</tr>
		<tr>
			<td>Lambda表达式 :<br /> #isMonitor=:[#this.name=='张三'?'班长':'学生']
			</td>
			<td><s:push value="#isMonitor=:[#this.name=='张三'?'班长':'学生']" />
				<ul>
					<s:iterator value="persons">
						<li><s:property value="name" />是:<s:property
								value="#isMonitor(top)" /></li>
					</s:iterator>
				</ul></td>
		</tr>
	</table>
	<form action="ognlAction" method="post">
		<input type="submit" value="submit" />
	</form>
</body>
</html>