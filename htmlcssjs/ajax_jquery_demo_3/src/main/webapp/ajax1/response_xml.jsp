<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
	function createXHR() {
		var xhr;
		if (window.ActiveXObject) {
			// 由于ie有多个不同版本的构造函数
			// 如果某个构造函数不被该ie支持，就抛出异常 可根据这个特性实现ie下对象创建
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else {
			xhr = new XMLHttpRequest();
		}
		return xhr;
	}
	function getInnerText() {
		xhr = createXHR();
		// 1打开连接
		xhr.open("get", "getInnerXML");
		// 2告诉事情干完了 如何通告当前页面的对象，注册回调函数
		xhr.onreadystatechange = function() {
			console.log(xhr.readyState + ":" + xhr.responseText);
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					//xhr.responseXML是一个document对象
					document.getElementById("myp").innerHTML = xhr.responseXML;
				} else {
					document.getElementById("myp").innerHTML = "请求错误";
				}
			}
		};
		// 3设置头部 可以省略
		// xhr.setRequestHeader();
		// 4发送请求
		xhr.send(null);
	}
</script>
</head>
<body>
	<input type="button" onclick="getInnerText()" value="单击">
	<p id="myp"></p>
</body>
</html>