;(function ($) {
	
	$.fn.extend({
		'nav' : function (color) {
			$(this).find('.nav').css({
				'list-style' : 'none',
				'margin' : 0,
				'padding' : 0,
				'display' : 'none',
				'color' : color
			});
			
			$(this).find('.nav').parent().hover(function () {
				$(this).find('.nav').slideDown('normal');
			}, function () {
				$(this).find('.nav').stop().slideUp('normal');
			});
		
			return this;
		}
	});
	
})(jQuery);