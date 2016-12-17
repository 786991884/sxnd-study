var xhr;

/**
 * 创建XHR对象
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
	//xhr.open("get", "/jquery/ex01/service.jsp?sName=" + sName);
	 //xhr.open("get", "/jquery/CustomerServiceServlet?sName=" + sName);
	// xhr.open("get", "/ajax01/servlet/CustomerServiceServlet?sName=" + sName);
	xhr.send(null);
}

function getStatusCallback() {
	if (xhr.readyState == 4) {
		if (xhr.status == 200) {
			var ret = xhr.responseText;
			var span = document.getElementById("status");

			if (ret.indexOf("yes") > -1) {
				span.innerHTML = "<font color='red'><b>online</b></font>";
			} else {
				span.innerHTML = "<font color='green'><b>outline</b></font>";
			}
		}
	}
}