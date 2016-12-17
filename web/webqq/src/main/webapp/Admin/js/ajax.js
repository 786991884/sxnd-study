function getFriends() {
	xhr = createXHR();
	$("#hello").click(
		function() {
			$.ajax({
				type : "post",
				url : "MyFriendsServlet",
				data : {},
				success : function(msg) {
					//alert(msg);
					var friends = eval('(' + msg + ')');
					$("#myhello").text("我是" + $("#username").val());
					$("#friends").empty();
					for ( var i = 0; i < friends.length; i++) {
						$("#friends").append(
							"<img alt='' src='" + friends[i].img
							+ "'/>");
						$("#friends").append(
							"<span><b>" + friends[i].name
							+ "</b>&nbsp&nbsp</span>");
						$("#friends")
							.append(
								"<span>" + friends[i].desc
								+ "</span><br/>");
					}
					$("#my").show(300);
					$("#friends").show(300);
				}
			});
		});
}