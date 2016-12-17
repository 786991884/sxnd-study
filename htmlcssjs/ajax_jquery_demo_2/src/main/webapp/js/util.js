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