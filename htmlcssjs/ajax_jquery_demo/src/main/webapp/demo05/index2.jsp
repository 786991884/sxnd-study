<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本动画</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<style type="text/css">
.userfrends {
	position: absolute;
	zIndex: 10000;
	left: 10px;
	top: 35px;
	width: 120px;
	height: 400px;
	border: 1px solid #CCEFF5;
	background-color: #FAFCFD;
	padding-top: 10px;
	padding-left: 10px;
}

.userfrends1 {
	position: absolute;
	zIndex: 10000;
	left: 210px;
	top: 35px;
	width: 120px;
	height: 400px;
	border: 1px solid #CCEFF5;
	background-color: #FAFCFD;
	padding-top: 10px;
	padding-left: 10px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		//$("#div1").hide();//隐藏
		$("#div1").hide(1000);//隐藏，历时1秒

		//$("#div2").show();//显示
		$("#div2").show(1000);//显示，历时1秒

		/* setTimeout(function() {
			$("body > div").toggle(1000);
		}, 3000); */
		setInterval(function(){$("body > div").toggle(1000)},3000);
	});
</script>
</head>
<body>
	<div id="div1" class="userfrends">
		我的好友<br> 我的好友<br> 我的好友<br> 我的好友<br> 我的好友<br>
	</div>

	<div id="div2" class="userfrends1" style="display: none;">
		我的好友<br> 我的好友<br> 我的好友<br> 我的好友<br> 我的好友<br>
	</div>
</body>
</html>