function manageUser(self) {
	var manageUser = document.getElementById("manageUser");
	manageUser.style.display = manageUser.style.display == "none" ? "block"
			: "none";
	if (manageUser.style.display == "none") {
		self.src = "Admin/images/manageUserDown.jpg";
	} else {
		self.src = "Admin/images/manageUserUp.jpg";
	}
}
function managerOrder(self) {
	var managerOrder = document.getElementById("managerOrder");
	managerOrder.style.display = managerOrder.style.display == "none" ? "block"
			: "none";
	if (managerOrder.style.display == "none") {
		self.src = "Admin/images/manages/manageOrderDown.jpg";

	} else {
		self.src = "Admin/images/manageOrderUp.jpg";
	}
}
function manageProduct(self) {
	var manageProduct = document.getElementById("manageProduct");
	manageProduct.style.display = manageProduct.style.display == "none" ? "block"
			: "none";
	if (manageProduct.style.display == "none") {
		self.src = "Admin/images/manageProductDown.jpg";
	} else {
		self.src = "Admin/images/manageProductUp.jpg";
	}
}
function manageInform(self) {
	var manageInform = document.getElementById("manageInform");
	manageInform.style.display = manageInform.style.display == "none" ? "block"
			: "none";
	if (manageInform.style.display == "none") {
		self.src = "Admin/images/manageInformDown.jpg";
	} else {
		self.src = "Admin/images/manageInformUp.jpg";
	}
}
function manageLiuyan(self) {
	var manageLiuyan = document.getElementById("manageLiuyan");
	manageLiuyan.style.display == manageLiuyan.style.display == "none" ? "block"
			: "none";
	if (manageLiuyan.style.display == "none") {
		self.src = "Admin/images/manageLiuyanDown.jpg";
	} else {
		self.src = "Admin/images/manageLiuyanUp.jpg";
	}
}
function manageMessage(self) {
	var manageMessage = document.getElementById("manageMessage");
	manageMessage.style.display = manageMessage.style.display == "none" ? "block"
			: "none";
	if (manageMessage.style.display == "none") {
		self.src = "Admin/images/manageMessageDown.jpg";
	} else {
		self.src = "Admin/images/manageMessageUp.jpg";
	}
}