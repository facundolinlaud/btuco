package com.fruta.btuco.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.PicturePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fruta.btuco.service.FileService;

import javax.imageio.ImageIO;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private PicturePathService picturePathService;

	@Override
	public void save(MultipartFile multipartFile) {
		String filePath = picturePathService.getPicturesPath() + multipartFile.getOriginalFilename();
		File dest = new File(filePath);

		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BufferedImage getImage(PictureMetadata picture) {
		try {
			return ImageIO.read(new File(picturePathService.buildPicturePath(picture)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
