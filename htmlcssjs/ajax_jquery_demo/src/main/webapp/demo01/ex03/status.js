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
	xhr.open("post", "/ajax_jquery_demo/CustomerServiceServlet");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("sName=" + sName);
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