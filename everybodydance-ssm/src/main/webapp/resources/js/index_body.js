		$(function() {
			//幻灯片
			var w_width = $(window).width();
			var w_banner = (1000 - w_width) / 2;
			$('.hot-event .event-item img').css('margin-left',
					'-' + w_banner + 'px');
		})