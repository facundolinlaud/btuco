var btuco = btuco || {};
btuco.commons = btuco.commons || {};
btuco.commons.pictures = btuco.commons.pictures || {};
btuco.commons.pictures.PictureCanvas = function(c, params){
    params = $.extend({
        width : null,
        height : null
    }, params);

    var
        $c = $(c),
        $e = null,
        ctx = null,
        rect = {},
        dragging = false;

    /*
     * Initialization
     */

    var init = function(){
        draw(params.width, params.height);
        initListeners();
    };

    var draw = function(width, height){
        $e = $('<canvas width="' + width + '" height="' + height + '" style="position: absolute; top: 0; left: 0"></canvas>');
        $c.append($e);

        ctx = $e.get(0).getContext('2d');
        ctx.strokeStyle = 'red';
    }

    var initListeners = function(){
        $e.on('mousedown', onMouseDown);
        $e.on('mouseup', onMouseUp);
        $e.on('mousemove', onMouseMove);
    };

    /*
     * Events
     */

    var onMouseDown = function(e){
        clear();

        var offset = $e.offset();
        rect.startX = e.pageX - offset.left;
        rect.startY = e.pageY - offset.top;

        dragging = true;
    }

    var onMouseUp = function(){
        dragging = false;
    };

    var onMouseMove = function(e){
        if (dragging) {
            var offset = $e.offset();
            rect.width = (e.pageX - offset.left) - rect.startX;
            rect.height = (e.pageY - offset.top) - rect.startY;

            clear();
            refresh();
        }
    };

    var clear = function(){
        ctx.clearRect(0, 0, $e.width(), $e.height());
    };

    var refresh = function(){
        ctx.strokeRect(rect.startX, rect.startY, rect.width, rect.height);
    };

	/*
	 * Control
	 */

	this.destroy = function(){
		$e.remove();
	};

    this.getSquare = function(){
        return rect;
    };

    init();
}