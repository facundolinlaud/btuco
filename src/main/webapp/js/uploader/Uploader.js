var btuco = btuco || {};
btuco.uploader = btuco.uploader || {};
btuco.uploader.Uploader = $(function(){
	var init = function(){
		var pictures = {};
		
		$('input.picture-input').MultiFile({
		    accept: 'jpg|png',
		    list: 'div.picture-input-list',
			onFileRemove: function(element, value, master_element) {
				pictures[value] = null;
				console.log(pictures);
				$('div.picture-input-log').append('<li>onFileRemove - ' + value + '</li>')
			},
			onFileAppend: function(element, value, master_element) {
				pictures[value] = element;
				console.log(pictures);
				$('div.picture-input-log').append('<li>onFileAppend - ' + value + '</li>')
			}
		});
	};
	
	init();
});