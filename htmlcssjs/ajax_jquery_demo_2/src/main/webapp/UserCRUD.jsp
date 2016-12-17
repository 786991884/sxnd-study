<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户的crud操作</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	//二：嵌入详细行
	//显示行详细
	grid.hideAllRowDetail();
	grid.showRowDetail(row);
	//将editForm元素，加入行详细单元格内
	var td = grid.getRowDetailCellEl(row);
	td.appendChild(editForm);
	editForm.style.display = "";

	//三：加载表单

	var form = new mini.Form("editForm1");
	if (grid.isNewRow(row)) {
		form.reset();
	} else {
		form.loading();
		$.ajax({
			url : "../data/DataService.aspx?method=GetEmployee&id=" + row.id,
			success : function(text) {
				var o = mini.decode(text);
				form.setData(o);
				form.unmask();
			}
		});
	}

	//四：提交表单

	var form = new mini.Form("editForm1");
	var o = form.getData();
	grid.loading("保存中，请稍后......");
	var json = mini.encode([ o ]);
	$.ajax({
		url : "../data/DataService.aspx?method=SaveEmployees",
		data : {
			employees : json
		},
		success : function(text) {
			grid.reload();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.responseText);
		}
	});
</script>
</head>
<body>
	<div id="editForm1"
		style="display: none; padding: 5px; position: relative;">
		<input class="mini-hidden" name="id" />
		<table style="width: 100%;">
			<tr>
				<td style="width: 80px;">用户id：</td>
				<td style="width: 150px;"><input name="loginname"
					class="mini-textbox" /></td>
				<td style="width: 80px;">账号：</td>
				<td style="width: 150px;"><input name="name"
					class="mini-textbox" /></td>
				<td style="width: 80px;">密码：</td>
				<td style="width: 150px;"><input name="salary"
					class="mini-textbox" /></td>
			</tr>
			<tr>
				<td
					style="text-align: right; padding-top: 5px; padding-right: 20px;"
					colspan="6"><a class="Update_Button"
					href="javascript:updateRow();">Update</a> <a class="Cancel_Button"
					href="javascript:cancelRow();">Cancel</a></td>
			</tr>
		</table>
	</div>
</body>
</html>