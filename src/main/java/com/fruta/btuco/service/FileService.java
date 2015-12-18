package com.fruta.btuco.service;

import com.fruta.btuco.model.PictureMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

public interface FileService {
	void save(MultipartFile multipartFile);

	BufferedImage getImage(PictureMetadata picture);
}
