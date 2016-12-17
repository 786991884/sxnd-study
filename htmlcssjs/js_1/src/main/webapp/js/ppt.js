// 文档加载完毕后才执行里面的代码
window.onload = function() {
	var index = 1;
	var timerId;
	var ul = document.getElementById("myUl");
	// 标签名字
	var lis = ul.getElementsByTagName("li");
	// 清除已有样式
	var img = document.getElementById("myImg");
	img.addEventListener("mouseover", stopChange);
	img.addEventListener("mouseout", startChange);
	function changeImg() {
		index++;
		if (index == 5) {
			index = 1;
		}
		document.getElementById("myImg").src = "img/" + index + ".jpg";
		changeCurrent();
	}
	// 当你的代码不放置在方法中，页面加载后立马
	timerId = window.setInterval(changeImg, 1000);
	function stopChange() {
		window.clearInterval(timerId);
	}
	function startChange() {
		timerId = window.setInterval(changeImg, 1000);
	}
	for (var i = 0; i < lis.length; i++) {
		lis[i].addEventListener("mouseover", function(e) {
			// 停止切换
			window.clearInterval(timerId);
			// 切换到对应的图片
			// 2.1得到那张图片
			//index = window.parseInt(this.innerHTML);
			index=this.innerHTML-0;
			// 2.2换src
			document.getElementById("myImg").src = "img/" + index + ".jpg";
			// 2.3指示当前图片
			changeCurrent();
		});
		lis[i].addEventListener("mouseout", function(e) {
			timerId = window.setInterval(changeImg, 1000);
		});
	}
	function changeCurrent() {

		for (var i = 0; i < lis.length; i++) {
			lis[i].className = "";
		}
		lis[index - 1].className = "on";

	}
}