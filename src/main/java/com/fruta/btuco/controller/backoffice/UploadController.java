package com.fruta.btuco.controller.backoffice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruta.btuco.model.Picture;
import com.fruta.btuco.model.Square;
import com.fruta.btuco.service.backoffice.UploadService;
import com.fruta.btuco.transformer.TriadicTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "backoffice/upload")
public class UploadController {
	private static final String UPLOAD_VIEW = "upload/upload";

	@Autowired
	private UploadService uploadService;

	@Autowired
	private TriadicTransformer<List<MultipartFile>, List<Square>, List<Picture>> picturesTransformer;

	@RequestMapping(method = RequestMethod.GET)
	public String getBackoffice(Model m) {
		return UPLOAD_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void uploadPictures(@RequestParam(value = "pictures[]") List<MultipartFile> files, @RequestParam(value = "squares") String squares) throws IOException {
		List<Picture> pictures = picturesTransformer.transform(files, squaresToList(squares));
		uploadService.save(pictures);
	}

	private List<Square> squaresToList(String squares) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(squares, new TypeReference<List<Square>>(){});
	}
}