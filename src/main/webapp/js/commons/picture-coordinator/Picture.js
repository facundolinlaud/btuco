var btuco = btuco || {};
btuco.commons = btuco.commons || {};
btuco.commons.pictures = btuco.commons.pictures || {};
btuco.commons.pictures.Picture = function(c, params){
	params = $.extend({
		pictureData : null,
		center : {
			x : null,
			y : null
		}
	}, params);

	var 
		$c = $(c),
		$e = null,
		$img = null,
		$dot = null;
	
	/*
	 * Initialization
	 */
	
	var init = function(){
		draw();
		loadPicture();
		initListeners();
	};
	
	var draw = function(){
		$e = $('<div></div>');
		$img = $('<img src>');
		$dot = $(
			'<label style="background-color: red; width: 5px; height: 5px;' +
			'border-radius: 5px; display: inline-block; position: absolute;"></label>'
		);
		
		$c.append($e.append($img).append($dot));
	};
	
	var loadPicture = function(){
		var reader = new FileReader();
		
		reader.onload = function (e) {
            $img.attr('src', e.target.result);
        }
		
		reader.readAsDataURL(params.pictureData);
	};
	
	var initListeners = function(){
		$img.on('click', onImageClick);
	};
	
	/*
	 * Events
	 */
	
	var onImageClick = function(e){
		var offset = $(this).offset();
	    var relativeX = (e.pageX - offset.left);
	    var relativeY = (e.pageY - offset.top);

	    params.center.x = relativeX;
	    params.center.y = relativeY;
	    
	    $dot.css('left', e.pageX);
	    $dot.css('top', e.pageY);
	};
	
	/*
	 * Control
	 */
	
	this.destroy = function(){
		$e.remove();
	};
	
	this.getParams = function(){
		return params;
	};
	
	init();
}