function showsimple() { // 创建主控制函数
	if (register.name.value == "") { // 判断用户名是否为空
		register.name.focus();
		return false;
	}
	if (register.pwd1.value == "") { // 判断密码是否为空
		register.pwd1.focus();
		return false;
	}
	if (register.yzm.value == "") { // 判断验证码是否为空
		register.yzm.focus();
		return false;
	}
	if (register.yzm.value != register.yzm2.value) { // 判断输入的验证码是否正确
		alert("效验码输入错误！");
		register.yzm.focus();
		return false;
	}
	var username = document.getElementById("name").value; // 获取表单提交的用户名
	var password = document.getElementById("pwd1").value; // 获取密码
	var post_method = "user=" + username + "&pass=" + password; // 构造URL参数
	xmlhttp.open("POST", "reg_chk.php", true); // 调用指定的添加文件
	xmlhttp.setRequestHeader("Content-Type",
		"application/x-www-form-urlencoded;"); // 设置请求头信息
	xmlhttp.onreadystatechange = StatHandler; // 判断URL调用的状态值并处理
	xmlhttp.send(post_method); // 将数据发送给服务器
}
function StatHandler() { // 定义处理函数
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) { // 判断如果执行成功，则输出下面内容
		document.getElementById("webpage").innerHTML = xmlhttp.responseText; // 将服务器返回的数据定义到DIV中
	}
}
function chkyzm(form) { // 对验证码进行验证
	if (form.yzm.value == "") {
		yzm1.innerHTML = "<font color=#FF0000>请输入效验码！</font>";
	} else if (form.yzm.value != form.yzm2.value) {
		yzm1.innerHTML = "<font color=#FF0000>效验码输入错误!</font>";
	} else {
		yzm1.innerHTML = "<font color=green>输入正确</font>";
	}
}
function yzm(form) { // 生成验证码
	var num1 = Math.round(Math.random() * 10000000);
	var num = num1.toString().substr(0, 4);
	document.write("<img name=codeimg src=yzm.php?num=" + num + "'>");
	form.yzm2.value = num;
}
function code(form) { // 重置验证码
	var num1 = Math.round(Math.random() * 10000000);
	var num = num1.toString().substr(0, 4);
	document.codeimg.src = "yzm.php?num=" + num;
	form.yzm2.value = num;
}