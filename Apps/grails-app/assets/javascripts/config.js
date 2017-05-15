window._skel_config = {
	preset: 'standard',
	prefix: 'css/style',
	resetCSS: true,
	breakpoints: {
		'desktop': {
			grid: {
				gutters: 50
			}
		}
	}
};

window._skel_panels_config = {
	preset: 'standard'
};

jQuery(function() {
	$('#nav > ul').dropotron({ 
		offsetY: -17,
		offsetX: -1,
		mode: 'fade',
		noOpenerFade: true,
		detach: false
	});
});