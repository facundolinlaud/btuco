var btuco = btuco || {};
btuco.upload = btuco.upload || {};
btuco.upload.Upload = $(function(){
	
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
		
		pictureCoordinator = new btuco.commons.pictures.PictureCoordinator($c, {
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
		sendFormData(buildFormData());
	};

	var buildFormData = function(){
		var formData = new FormData();

		var files = pictureCoordinator.toJSON();

		for(var i = 0; i < files.pictures.length; i++){
			var picture = files.pictures[i];
			formData.append('pictures[]', picture, picture.name);

			var center = files.centers[i];
			formData.append('centers[]', center.x + ";" + center.y);
		}

		return formData;
	};

	var sendFormData = function(formData){
		$.ajax({
			url: '/backoffice/upload',
			data: formData,
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
			console.log("ok");
			console.log(data);
			}
		});
	}
	
	init();
});