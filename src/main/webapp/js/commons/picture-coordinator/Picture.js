var btuco = btuco || {};
btuco.commons = btuco.commons || {};
btuco.commons.pictures = btuco.commons.pictures || {};
btuco.commons.pictures.Picture = function(c, params){
	params = $.extend({
		pictureData : null
	}, params);

	var 
		$c = $(c),
		$e = null,
		$img = null,
		canvas = null;

	/*
	 * Initialization
	 */
	
	var init = function(){
		draw();
		loadCanvas();
		loadPicture();
	};
	
	var draw = function(){
		$e = $('<div style="position: relative"></div>');
		$img = $('<img draggable="false" src>');

		$c.append($e.append($img));
	};

	var loadPicture = function(){
		var reader = new FileReader();
		
		reader.onload = function (e) {
            $img.attr('src', e.target.result);
            loadCanvas($img.width(), $img.height());
        }
		
		reader.readAsDataURL(params.pictureData);
	};

	var loadCanvas = function(width, height){
        canvas = new btuco.commons.pictures.PictureCanvas($e, {
            width: width,
            height: height
        });
    };

	/*
	 * Control
	 */
	
	this.destroy = function(){
		$e.remove();
	};
	
	this.getParams = function(){
	    var extendedParams = $.extend(true, {}, params);
		extendedParams.square = canvas.getSquare();

		return extendesParams;
	};
	
	init();
}