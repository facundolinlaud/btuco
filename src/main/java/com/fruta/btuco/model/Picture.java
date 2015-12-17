package com.fruta.btuco.model;

import java.awt.Point;

import org.springframework.web.multipart.MultipartFile;

public class Picture {
	private MultipartFile file;
	private Point center;

	public Picture() {
		super();
	}

	public Picture(MultipartFile file, Point center) {
		super();
		this.file = file;
		this.center = center;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Picture [file=" + file + ", center=" + center + "]";
	}
}