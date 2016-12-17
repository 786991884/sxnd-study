<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sj:head jqueryui="true"/>
</head>
<body>
	<!-- 执行remotetabaction的dowebpagetab方法 -->
	<s:url id="remoteurl1" action="remoteTabAction" method="doWebPageTab"></s:url>
	<s:url id="remoteurl2" action="remoteTabAction" method="doNewsTab"></s:url>
	<s:url id="remoteurl3" action="remoteTabAction" method="doMusicTab"></s:url>
	<s:url id="remoteurl4" action="remoteTabAction" method="doPictureTab"></s:url>
	<!-- selectedTab:默认选中的选项卡
	animate:有动画效果
	selectedTab:选中的tab，默认为0 -->
	<sj:tabbedpanel id="remotetabs" selectedTab="2" animate="true"
		spinner="正在加载。。。">
		<sj:tab id="tab1" href="%{remoteurl1}" label="网页"></sj:tab>
		<sj:tab id="tab2" href="%{remoteurl2}" label="新闻"></sj:tab>
		<sj:tab id="tab3" href="%{remoteurl3}" label="音乐"></sj:tab>
		<sj:tab id="tab4" href="%{remoteurl4}" label="图片"></sj:tab>
	</sj:tabbedpanel>
</body>
</html>