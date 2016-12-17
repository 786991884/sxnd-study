$.extend($.fn.validatebox.defaults.rules, {
	midLength : {
		validator : function(value, param) {
			return value.length >= param[0] && value.length <= param[1];
		},
		message : '请输入{0}-{1}字符.'
	},
	equalLength : {
		validator : function(value, param) {
			return value.length == param[0];
		},
		message : '必须输入{0}个字符.'
	}
});
$.extend($.fn.datagrid.defaults.editors, {
	datetimebox : {
		init : function(container, options) {
			var box = $('<input />').appendTo(container);
			box.datetimebox(options);
			return box;
		},
		getValue : function(target) {
			return $(target).datetimebox('getValue');
		},
		setValue : function(target, value) {
			$(target).datetimebox('setValue', value);
		},
		resize : function(target, width) {
			var box = $(target);
			box.datetimebox('resize', width);
		},
		destroy : function(target) {
			$(target).datetimebox('destroy');
		}
	}
});
