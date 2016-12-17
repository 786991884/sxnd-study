<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#divs").hide();
		$("#urlcontent").hide();
		$("#loadMsg").hide();
	})
	function show() {
		$
				.ajax({
					global : true,
					type : 'post',
					url : "findAllUser.action",
					data : {
						method : 'show',
					},
					success : function(data) {
						var divNode = $("#divs");
						divNode.html("");
						if (data != "null") {
							var o = eval("(" + data + ")");
							var title = $("<div>");
							title
									.html("|<span>编号</span>|<span>姓名</span>|<span>心情</span>|<span>发布时间</span>|");
							title.appendTo(divNode);
							$.each(o, function(i, n) {
								var div = $("<div>");
								var span = "|"
								$.each(n, function(pro, val) {
									span = span + "<span>" + val + "</span>|";
								})
								div.html(span).appendTo(divNode);
							})
							divNode.show();
						} else {
							$("#msg").html("没有数据信息");
						}
					}
				});
	}
	function add() {
		$("#divs").hide();
		var a_name = $("#a_name").val();
		var a_feeling = $("#a_feeling").val();
		if (a_name == "" || a_feeling == "") {
			alert("输入信息不能为空！");
			return;
		}
		$.ajax({
			type : 'post',
			url : "control",
			data : {
				method : 'add',
				a_name : a_name,
				a_feeling : a_feeling
			},
			success : function(data) {
				$("#msg").html(data);
				$("#v_a_name").html(a_name);
				$("#v_a_feeling").html(a_feeling);
			}
		});
	}
	function update() {
		$("#divs").hide();
		var a_id = $("#a_id").val();
		var a_name = $("#a_name").val();
		var a_feeling = $("#a_feeling").val();
		if (a_id == "" && a_name == "" && a_feeling == "") {
			alert("输入编号或者信息不能为空！");
			return;
		}
		$.ajax({
			type : 'post',
			url : "control",
			data : {
				method : 'update',
				a_name : a_name,
				a_feeling : a_feeling,
				a_id : a_id
			},
			success : function(data) {
				$("#msg").html(data);
				$("#v_a_id").html(a_id);
				$("#v_a_name").html(a_name);
				$("#v_a_feeling").html(a_feeling);
			}
		});
	}
	function del() {
		$("#divs").hide();
		var a_id = $("#a_id").val();
		if (a_id == "") {
			alert("输入编号不能为空！");
			return;
		}
		$.ajax({
			type : 'post',
			url : "control",
			data : {
				method : 'delete',
				a_id : a_id
			},
			success : function(data) {
				$("#msg").html(data);
			}
		});
	}
	function query() {
		var a_id = $("#a_id").val();
		if (a_id == "") {
			alert("输入编号不能为空！");
			return;
		}
		$
				.ajax({
					type : 'post',
					url : "control",
					data : {
						method : 'query',
						a_id : a_id
					},
					success : function(data) {
						var divNode = $("#divs");
						divNode.html("");
						if (data != "null") {
							var o = eval("(" + data + ")");
							var title = $("<div>");
							title
									.html("|<span>编号</span>|<span>姓名</span>|<span>心情</span>|<span>发布时间</span>|");
							title.appendTo(divNode);
							$.each(o, function(i, n) {
								var div = $("<div>");
								var span = "|";
								$.each(n, function(pro, val) {
									span = span + "<span>" + val + "</span>|";
								})
								div.html(span).appendTo(divNode);
							})
							divNode.show();
						} else {
							$("#msg").html("没有数据信息");
						}
					}
				});
	}
</script>
</head>
<body>
		<div>
			<div>
				<label id="l_a_name">姓名：</label> <input type="text" id="a_name"
					name="a_name" /><br /> <label id="l_a_feeling">心情：</label><br />
				<textarea rows="10" cols="30" id="a_feeling" name="a_feeling"></textarea>
				<div>
					<label id="msg"></label>
				</div>
			</div>
			<div>
				<span>
					<button id="show" name="show" value="show"></button> <span><button
							id="add" name="add" value="add"></button> <span> <label
							id="l_a_id">编号：</label><input type="text" id="a_id" name="a_id" />
							<button id="update" name="update" value="update"></button>
					</span> <span>
							<button id="del" name="del" value="delete"></button>
					</span> <span>
							<button id="query" name="query" value="query"></button>
					</span>
			</div>
			<div>
				<span id="v_a_id"></span> <span id="v_a_name"></span> <span
					id="v_a_feeling"></span> <span id="v_a_time"></span>
			</div>
			<div id="divs" align="center"></div>
		</div>
	<div>
		网址：<input type="text" id="url" name="url" /> <input type="button"
			id="get" value="加载" />
		<div id="urlcontent"></div>
	</div>
	<div>
		<input id="wether" type="button" value="获取JSON数据" />
		<div id="loadMsg">请稍等，数据正在加载...</div>
		<div id="imageDiv"></div>
	</div>
</body>
</html>