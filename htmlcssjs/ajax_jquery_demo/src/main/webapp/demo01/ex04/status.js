var xhr;

/**
 * create XHR
 */
function createXHR() {
	if (window.ActiveXObject) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		alert("can't create xhr object!");
	}
}

function getStatus() {
	var sName = document.getElementById("sName").value;

	createXHR();

	xhr.onreadystatechange = getStatusCallback;
	xhr.open("get", "/ajax_jquery_demo/CustomerServiceServlet");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("sName=" + sName);
}

function getStatusCallback() {
	if (xhr.readyState == 0) {
		alert("未初始化");
	} else if (xhr.readyState == 1) {
		alert("正在加载");
	} else if (xhr.readyState == 2) {
		alert("已加载");
	} else if (xhr.readyState == 3) {
		alert("交互中");
	} else if (xhr.readyState == 4) {
		alert("完成");
		if (xhr.status == 200) {
			alert(xhr.responseText);
		} else if (xhr.status == 404) {
			alert(404);
		}
	}
}