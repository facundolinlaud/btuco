var commons = commons || {};
commons.components = commons.components || {};
commons.components.PictureCoordinator = function(c, params){
	params = $.extend({
		$formPictures : null
	}, params);
	
	var 
		$c = $(c),
		$e = null,
		$pictures = null,
		pictures = [];
	
	/*
	 * Initialization
	 */
	
	var init = function(){
		draw();
		initListeners();
	};
	
	var draw = function(){
		$e = $(
			'<div>' +
			'</div>');
		
		$pictures = $(
			'<div class="pictures">' +
			'</div>');
		
		$c.append($e.append($pictures));
	};
	
	var initListeners = function(){
		params.$formPictures.change(function(){
			updatePictures(this);
		});
	};
	
	/*
	 * Events
	 */
	
	var updatePictures = function(input){
		clearPictures();
		
		for(var i = 0; i < input.files.length; i++){
			pictures.push(new commons.components.Picture($pictures, {
				pictureData : input.files[i]
			}));
		}
	};
	
	/*
	 * Control
	 */
	
	var clearPictures = function(){
		while(pictures.length){
			pictures.pop().destroy();
		}
	};
	
	init();
};