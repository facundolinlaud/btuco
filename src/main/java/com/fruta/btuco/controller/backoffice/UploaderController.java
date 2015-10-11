package com.fruta.btuco.controller.backoffice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "backoffice/upload")
public class UploaderController {
	private static final String UPLOADER = "uploader/uploader";

	// private ImagesService imagesService;

	@RequestMapping(method = RequestMethod.GET)
	public String getUploader(Model m) {
		// m.addAttribute("students", studentService.findAll());
		return UPLOADER;
	}

	// @ResponseBody
	// public WebResponse<Boolean> updateEUSettings(final Locale locale, @Valid
	// final EUPSettingsWrapper endUserPortalSettingsWrapper,
	// @RequestParam(value = "file1", required = true) final MultipartFile logo)
	// {
	//
	// }

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void uploadPicture(@RequestParam(value = "metadata") String metadata,
			@RequestParam(value = "pictures[]") MultipartFile[] pictures) {
		System.out.println(metadata);
		System.out.println(pictures);
	}
}