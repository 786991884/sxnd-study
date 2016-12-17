var img = document.getElementById("myimg");
var counter = 1;
var timerId;
function change() {
	timerId = window.setInterval(changeImg, 2000);
}
function changeImg() {
	img.src = "images/photo" + counter + ".jpg";
	var lis = myimg.parentNode.getElementsByTagName("li");
	for (li in lis) {
		// 每步的变量对数组来说是索引
		lis[li].className = "";
	}
	lis[counter - 1].className = "current";
	counter++;
	if (counter > 4)
		counter = 1;
	// 清除当前的li的样式，然后设置下一个
}
function bindTransfer() {
	myimg.onmouseover = function() {
		clearInterval(timerId);
	}
	myimg.onmouseout = function() {
		timerId = window.setInterval(changeImg, 2000);
	}
	var lis = myimg.parentNode.getElementsByTagName("li");
	for (li in lis) {
		// 每步的变量对数组来说是索引
		lis[li].onclick = function() {
			counter = parseInt(this.innerHTML);
			changeImg();
		}
	}
}
change();
bindTransfer();