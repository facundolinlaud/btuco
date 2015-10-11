package com.fruta.btuco.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fruta.btuco.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Value("pictures.directory")
	private String picturesDirectory;

	@Override
	public void save(MultipartFile multipartFile) {
		String filePath = picturesDirectory + multipartFile.getOriginalFilename();
		File dest = new File(filePath);

		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private File multipartFileToFile(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}
