<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>级联下拉列表</title>
<script type="text/javascript" src="../js/AjaxRequest.js"></script>
<script type="text/javascript">
	//获取省份和直辖市
	function getProvince() {
		var loader = new net.AjaxRequest(
				"ZoneServlet?action=getProvince&nocache="
						+ new Date().getTime(), deal_getProvince, onerror,
				"GET");
	}
	function deal_getProvince() {
		provinceArr = this.req.responseText.split(","); //将获取的省份名称字符串分隔为数组

		for (i = 0; i < provinceArr.length; i++) { //通过循环将数组中的省份名称添加到下拉列表中
			document.getElementById("province").options[i] = new Option(
					provinceArr[i], provinceArr[i]);
		}
		if (provinceArr[0] != "") {
			getCity(provinceArr[0]); //获取市县
		}
	}
	window.onload = function() {
		getProvince(); //获取省份和直辖市
	}
	/*************************************************************************************************************/
	//获取市县
	function getCity(selProvince) {
		var loader = new net.AjaxRequest(
				"ZoneServlet?action=getCity&parProvince=" + selProvince
						+ "&nocache=" + new Date().getTime(), deal_getCity,
				onerror, "GET");
	}
	function deal_getCity() {
		cityArr = this.req.responseText.split(","); //将获取的市县名称字符串分隔为数组
		document.getElementById("city").length = 0; //清空下拉列表
		for (i = 0; i < cityArr.length; i++) { //通过循环将数组中的市县名称添加到下拉列表中
			document.getElementById("city").options[i] = new Option(cityArr[i],
					cityArr[i]);
		}
	}
	function onerror() {
	} //错误处理函数
</script>
</head>
<body>
	请选择：
	<select name="province" id="province" onChange="getCity(this.value)">
	</select> -
	<select name="city" id="city">
	</select>
</body>
</html>