var xmlhttp = false; // 初始化变量
// 如果ActiveXObject存在，说明是IE5.0以上的版本，否则使用XMLHttpRequest创建
if (window.ActiveXObject) {
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
} else if (window.XMLHttpReuqest) {
	xmlhttp = new XMLHttpRequest();
}
