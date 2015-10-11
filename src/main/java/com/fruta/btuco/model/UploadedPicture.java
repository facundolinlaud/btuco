package com.fruta.btuco.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadedPicture {
	private MultipartFile picture;

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
}
