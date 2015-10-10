package com.fruta.btuco.controller.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "backoffice")
public class UploaderController {
	private static final String UPLOADER = "uploader/uploader";

	// private ImagesService imagesService;

	@RequestMapping(value = "/uploader", method = RequestMethod.GET)
	public String getUploader(Model m) {
		// m.addAttribute("students", studentService.findAll());
		return UPLOADER;
	}
}
