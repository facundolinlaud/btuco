package com.fruta.btuco.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public void save(MultipartFile multipartFile);
}
