var btuco = btuco || {};
btuco.uploader = btuco.uploader || {};
btuco.uploader.Uploader = $(function(){
	
	var pictureCoordinator = null;
	
	/*
	 * Initialization
	 */
	
	var init = function(){
		initPictureCoordinator();
		initListeners();
	};
	
	var initPictureCoordinator = function(){
		var $c = $('.picture-coordinator');
		
		pictureCoordinator = new commons.components.PictureCoordinator($c, {
			$formPictures : $('input.pictures')
		});
	}
	
	var initListeners = function(){
		$('#picturesForm').on('submit', onSubmit);
	};
	
	/*
	 * Events
	 */
	
	var onSubmit = function(e){
		e.preventDefault();
		console.log("updating");
		updatePictures();
	};
	
	/*
	 * Control
	 */
	
	var updatePictures = function(){
		var formData = new FormData();
		
		var files = pictureCoordinator.toJSON();
		formData.append('metadata', JSON.stringify(files.metadata));
		
		for(var i = 0; i < files.pictures.length; i++){
			var picture = files.pictures[i];
			
			formData.append('pictures[]', picture, picture.name);
		}
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/backoffice/upload', true);
		xhr.onload = function () {
			if (xhr.status === 200) {
				console.log("done")
			} else {
				alert('An error occurred!');
			}
		};
		xhr.send(formData);
	};
	
	init();
});