package com.fruta.btuco.model;

import java.awt.Point;

import org.springframework.data.annotation.Id;

public class PictureMetadata implements Resource {
	@Id
	private String id;
	private String name;
	private Point center;

	public PictureMetadata(String name, Point center) {
		super();
		this.name = name;
		this.center = center;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "PictureMetadata [id=" + id + ", name=" + name + ", center=" + center + "]";
	}
}
