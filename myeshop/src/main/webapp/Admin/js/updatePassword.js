var checkPassword_ = false;
function checkPassword() {
	var password = document.getElementById("password");
	var passwordDiv = document.getElementById("passwordDiv");
	if (password.value == "") {
		passwordDiv.innerHTML = "密码不能为空";
		checkPassword_ = false;
	} else {
		passwordDiv.innerHTML = "";
		checkPassword_ = true;
	}
}
var checkRpassword_ = false;
function checkRpassword() {
	var rpassword = document.getElementById("rpassword");
	var password = document.getElementById("password");
	if (rpassword.value == "") {
		rpasswordDiv.innerHTML = "确认密码不能为空";
		checkRpassword_ = false;
	} else if (password.value != rpassword.value) {
		rpasswordDiv.innerHTML = "再次密码不一样";
		checkRpassword_ = false;
	} else {
		rpasswordDiv.innerHTML = "";
		checkRpassword_ = true;
	}
}
function update() {
	var oForm = document.getElementsByTagName("form"[0]);
	var messageDiv = document.getElementById("messageDiv");
	if (checkRpassword_ && checkPassword_) {
		var name = oForm.name.value;
		var password = oForm.rpassword.value;
		oForm.action = "adminUpdatePassword?name=" + name + "&password="
			+ password + "&rpassword=" + rpassword;
		oForm.submit();

	} else {
		messageDiv.innerHTML = "请输入正确的数据";
	}
}
