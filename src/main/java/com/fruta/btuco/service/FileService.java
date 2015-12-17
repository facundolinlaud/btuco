package com.fruta.btuco.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	void save(MultipartFile multipartFile);
}
