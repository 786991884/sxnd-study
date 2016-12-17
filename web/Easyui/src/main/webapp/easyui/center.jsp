<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#datagrid').datagrid({
			idField : 'id',
			rowStyle : function(rowIndex, rowData) {
				if (rowData.name == 'admin') {
					return 'background-color:#6293BB;color:#fff;';
				}

			},
			url : '',
			//title : '用户',
			iconCls : 'icon-save',
			pagination : true,
			pageSize : 5,
			pageList : [ 5, 10, 15, 20, 50 ],
			fit : true,
			fitColumns : false,
			nowarp : false,
			border : false,
			sortName : 'name',
			sortOrder : 'asc',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 100,
				checkbox : true,
				align : 'center'
			}, {
				field : 'id',
				title : '控制',
				width : 100,
				formatter : function(value, row, index) {
					return '<button onClick="show(' + index + ')">编辑</button><button>删除</button>';
				}
			}, {
				field : 'name',
				title : 'Name',
				width : 100,
				sortable : true,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				},
				formatter : function(value, row, index) {
					if (row.user) {
						return row.user.name;
					} else {
						return value;
					}
				},
				styler : function(value, row, index) {
					if (value < 20) {
						return 'background-color:#ffee00;color:red;';
					}
				}

			}, {
				field : 'datetime',
				title : '日期日间',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					return new Date(value);

				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
				}
			} ],
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}

		});
		$('.datagrid-header div').css('textAlign', 'center');
		search = function() {
			$('#datagrid').datagrid('load', {
				name : $('#search_Form').find('[name=name]').val()
			});
		};
	});
	function show(i) {
		var rows = $('#datagrid').datagrid('getRows');
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" title="查询条件" style="height: 100px; overflow: hidden;">
		<form method="post" id="search_Form">
			<tr>
				<th>用户名</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>创建时间</th>
				<td><input name="createTime" class="easyui-datetimebox" data-options="editable:false"></td>
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="">查询</a>
			</tr>
		</form>
	</div>
	<div title="用户管理" data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
</div>

<div id="menu" class="easyui-menu" style="width: 120px; display: none;">
	<div onclick="" data-options="iconCls:'icon-add'">增加</div>
	<div onclick="" data-options="iconCls:'icon-remove'">删除</div>
	<div onclick="" data-options="iconCls:'icon-edit'">编辑</div>
</div>