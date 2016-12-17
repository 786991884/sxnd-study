<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tree和treenode标签</title>
<sx:head parseContent="true" />
</head>
<body>
	<sx:tree label="计算机图书" id="book" showRootGrid="true" showGrid="true"
		treeSelectedTopic="treeSelected">
		<sx:treenode label="Oracle" id="Oracle">
			<sx:treenode label="java核心" id="javaSE" />
			<sx:treenode label="servlet" id="servlet" />
			<sx:treenode label="oracle管理" id="oracle" />
		</sx:treenode>
		<sx:treenode label="David" id="David">
			<sx:treenode label="JavaScript" id="javascript" />
		</sx:treenode>
		<sx:treenode label="Johnson" id="Johnson">
			<sx:treenode label="javaEE" id="javaEE" />
		</sx:treenode>
	</sx:tree>
</body>
</html>