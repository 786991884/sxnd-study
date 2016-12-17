<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JS省市县三级联动下拉框</title>
<script type="text/javascript">
	/*  
	 **    类名：CLASS_LIANDONG  
	 **    功能：省市县联动菜单  
	 **    
	 **/
	function CLASS_LIANDONG(array) {
		//数组，联动的数据源
		this.array = array;
		this.indexName = '';
		this.obj = '';
		//设置子SELECT
		// 参数：当前onchange的SELECT ID，要设置的SELECT ID
		this.subSelectChange = function(selectName1, selectName2) {
			//try
			//{
			var obj1 = document.all[selectName1];
			var obj2 = document.all[selectName2];
			var objName = this.toString();
			var me = this;
			obj1.onchange = function() {
				me.optionChange(this.options[this.selectedIndex].value, obj2.id)
			}
		}
		//设置第一个SELECT
		// 参数：indexName指选中项,selectName指select的ID
		this.firstSelectChange = function(indexName, selectName) {
			this.obj = document.all[selectName];
			this.indexName = indexName;
			this.optionChange(this.indexName, this.obj.id)
		}

		// indexName指选中项,selectName指select的ID
		this.optionChange = function(indexName, selectName) {
			var obj1 = document.all[selectName];
			if (selectName == "s2") {
				document.all["s3"].length = 0;
				document.all["s3"].options[0] = new Option("请选择", '');
			}

			var me = this;
			obj1.length = 0;
			obj1.options[0] = new Option("请选择", '');
			for (var i = 0; i < this.array.length; i++) {
				if (this.array[i][1] == indexName) {
					//alert(this.array[i][1]+" "+indexName);
					obj1.options[obj1.length] = new Option(this.array[i][2], this.array[i][0]);
				}
			}
		}
	}
</script>
</head>
<body>
	<form name="form1" method="post">
		<select id="s1" name="s1">
			<option selected></option>
		</select> <select id="s2" name="s2">
			<option selected></option>
		</select> <select id="s3" name="s3">
			<option selected></option>
		</select>
	</form>
	<script type="text/javascript" src="ssld.js"></script>
</body>
</html>