$(document).ready(function() {
	// alert("document ready");
});

$(function() {
	// alert("function");
});

$(document).ready(function() {
	// 隐藏当前元素
	$("a").click(function() {
		$(this).hide();
	});
	// $("#jQuery110").hide();//隐藏id=jQuery110的元素
	// $("p.nice").hide();//隐藏class=nice的所有段落
	// $("p").hide();//隐藏所有段落
	// $("#jQuery110").css("backgroundColor", "red");
	$("p").css({
		"backgroundColor" : "#00FAFB",
		"color" : "red"
	});
});
