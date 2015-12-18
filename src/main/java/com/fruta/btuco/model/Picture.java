package com.fruta.btuco.model;

import org.springframework.web.multipart.MultipartFile;

public class Picture {
	private MultipartFile file;
	private Square square;

	public Picture() {
		super();
	}

	public Picture(MultipartFile file, Square square) {
		this.file = file;
		this.square = square;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	@Override
	public String toString() {
		return "Picture{" +
				"file=" + file +
				", square=" + square +
				'}';
	}
}