function showTime() {
	var timeId = document.getElementById("timeId");
	var x = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	var day = e.getUTCDay();
	timeId.innerHTML = "日期：" + e.getLYear() + "年" + (e.getMonth() + 1) + "月"
		+ e.getDate() + "日" + x[day];
}
