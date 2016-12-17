var xhrStatus;
var xhrGoods;

/**
 * 创建XHR对象
 */
function createXHR() {
	var xhr = null;
	if (window.ActiveXObject) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		alert("can't create xhr object!");
	}

	return xhr;
}

function getStatus() {
	var span = document.getElementById("status");
	span.innerHTML = "开始时间：" + (new Date()).toLocaleTimeString();

	var sName = document.getElementById("sName").value;
	xhrStatus = createXHR();

	xhrStatus.onreadystatechange = getStatusCallback;
	xhrStatus.open("get", "/ajax_jquery_demo/CustomerServiceServlet?sName=" + sName);
	xhrStatus.send(null);
}

function getGoods() {
	var span = document.getElementById("goods");
	span.innerHTML = "开始时间：" + (new Date()).toLocaleTimeString();

	var gName = document.getElementById("gName").value;
	xhrGoods = createXHR();

	xhrGoods.onreadystatechange = getGoodsCallback;
	xhrGoods.open("get", "/ajax_jquery_demo/GoodsServlet?gName=" + gName);
	xhrGoods.send(null);
}

function getStatusCallback() {
	if (xhrStatus.readyState == 4) {
		if (xhrStatus.status == 200) {
			var ret = xhrStatus.responseText;
			var span = document.getElementById("status");

			if (ret.indexOf("yes") > -1) {
				span.innerHTML += "--响应时间：" + (new Date()).toLocaleTimeString() + "--<font color='red'><b>在线</b></font>";
			} else {
				span.innerHTML += "--响应时间：" + (new Date()).toLocaleTimeString() + "--<font color='green'><b>离线</b></font>";
			}
		}
	}
}

function getGoodsCallback() {
	if (xhrGoods.readyState == 4) {
		if (xhrGoods.status == 200) {
			var ret = xhrGoods.responseText;
			var span = document.getElementById("goods");

			span.innerHTML += "--响应时间：" + (new Date()).toLocaleTimeString() + "--商品数量：" + ret;
		}
	}
}