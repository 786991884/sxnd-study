<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
body {
	font-size: 12px
}
</style>
</head>
<body>
	<a href="themesAction">默认主题</a>
	<a href="themesAction" ?themes=blitzer>主题一</a>
	<a href="themesAction" ?themes=cupertino>主题二</a>
	<a href="themesAction" ?themes=start>主题三</a>
	<s:if test="%{#parameters.themes==null}">
		<sj:head jqueryui="true" />
	</s:if>
	<s:else>
		<sj:head jqueryui="true" jquerytheme="%{#parameters.themes}"
			customBasepath="template.themes" />
	</s:else>

	<sj:tabbedpanel id="localtabs">
		<sj:tab id="tab1" target="tone" label="邮箱推荐"></sj:tab>
		<sj:tab id="tab2" target="ttwo" label="今日新闻"></sj:tab>
		<sj:tab id="tab3" target="tthree" label="博客热点"></sj:tab>
		<sj:tab id="tab4" target="tfour" label="视频大片"></sj:tab>
		<div id="tone">
			网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱网易企业邮箱</div>
		<div id="ttwo">
			中方谈美国强硬态度：望相向而行<br> 中方谈美国强硬态度：望相向而行<br> 中方谈美国强硬态度：望相向而行<br>
			中方谈美国强硬态度：望相向而行
		</div>
		<div id="tthree">
			征集便宜背后的故事<br> 征集便宜背后的故事<br> 征集便宜背后的故事<br>征集便宜背后的故事
		</div>
		<div id="tfour">
			重庆最有钱的黑老大被判死刑<br> 重庆最有钱的黑老大被判死刑<br> 重庆最有钱的黑老大被判死刑<br>
			重庆最有钱的黑老大被判死刑
		</div>
	</sj:tabbedpanel>


</body>
</html>