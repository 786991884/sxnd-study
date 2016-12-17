function selectAll() {
	var deletes = document.getElementById("delete");
	var selectAll = document.getElementById("selectAll");
	for ( var i = 0; i < deletes.length; i++) {
		if (selectAll.checked == true) {
			deletes[i].checked = true;
		} else {
			deletes[i].checked = false;
		}
	}
}
function removeUser(pageOffset, pageSize) {
	var deletes = document.getElementById("delete");
	var count = 0;
	var users = new Array();
	for ( var i = 0; i < deletes.length; i++) {
		if (deletes[i].checked) {
			count++;
			users.push(deletes[i].value);
		}
	}
	if (count == 0) {
		alert("还没有选中删除项");
		return false;
	}
	var oform = document.getElementsByTagName("form")[0];
	oform.action = "deleteUserServlet?userIds=" + users + "&pageOfffset="
		+ pageOffset + "&pageSize=" + pageSize;
	oform.submit();
}