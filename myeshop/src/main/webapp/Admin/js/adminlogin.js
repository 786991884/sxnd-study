function login(self) {
	var name = document.getElementById("name");
	var password = document.getElementById("password");
	if (name.value != "" && password.value != "") {
		self.href = "adminLoginServlet?name=" + name.value + "&" + "password="
				+ password.value;
	}
}
function reset() {
	var name = document.getElementById("name");
	var password = document.getElementById("password");
	name.value = "";
	password.value = "";
}
