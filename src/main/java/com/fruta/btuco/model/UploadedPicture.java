package com.fruta.btuco.model;


public class UploadedPicture {
	private String metadata;

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "UploadedPicture [metadata=" + metadata + "]";
	}

	// private MultipartFile picture;
	//
	// public MultipartFile getPicture() {
	// return picture;
	// }
	//
	// public void setPicture(MultipartFile picture) {
	// this.picture = picture;
	// }
}
