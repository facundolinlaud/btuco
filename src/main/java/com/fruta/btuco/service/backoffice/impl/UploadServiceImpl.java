package com.fruta.btuco.service.backoffice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruta.btuco.dao.PicturesDao;
import com.fruta.btuco.model.Picture;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.FileService;
import com.fruta.btuco.service.backoffice.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private FileService fileService;

	@Autowired
	private PicturesDao picturesDao;

	@Override
	public void save(List<Picture> pictures) {
		pictures.stream().forEach(p -> doShit(p));
	}

	private void doShit(Picture picture) {
		saveToDisk(picture);
		saveToDatabase(picture);
	}

	private void saveToDatabase(Picture picture) {
		String pictureName = picture.getFile().getOriginalFilename();
		PictureMetadata pictureMetadata = new PictureMetadata(pictureName, picture.getSquare());

		picturesDao.save(pictureMetadata);
	}

	private void saveToDisk(Picture picture) {
		fileService.save(picture.getFile());
	}

}
