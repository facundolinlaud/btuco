package com.fruta.btuco.controller.backoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.fruta.btuco.model.Picture;
import com.fruta.btuco.service.UploadService;
import com.fruta.btuco.transformer.TriadicTransformer;

@Controller
@RequestMapping(value = "backoffice/upload")
public class UploadController {
	private static final String UPLOAD_VIEW = "upload/upload";

	@Autowired
	private UploadService uploadService;

	@Autowired
	private TriadicTransformer<List<MultipartFile>, List<String>, List<Picture>> picturesTransformer;

	@RequestMapping(method = RequestMethod.GET)
	public String getBackoffice(Model m) {
		return UPLOAD_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void uploadPictures(@RequestParam(value = "pictures[]") List<MultipartFile> files,
			@RequestParam(value = "centers[]") List<String> centers) {
		List<Picture> pictures = picturesTransformer.transform(files, centers);
		uploadService.save(pictures);
	}
}