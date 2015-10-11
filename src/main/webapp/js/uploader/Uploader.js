var btuco = btuco || {};
btuco.uploader = btuco.uploader || {};
btuco.uploader.Uploader = $(function(){
	var init = function(){
		initPictureCoordinator();
	};
	
	var initPictureCoordinator = function(){
		var 
			$c = $('.picture-coordinator'),
			pictureCoordinator = new commons.components.PictureCoordinator($c, {
				$formPictures : $('input.pictures')
			});
	}
	
	init();
});