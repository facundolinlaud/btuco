package com.fruta.btuco.model;

import org.springframework.data.annotation.Id;

import java.awt.*;

public class PictureMetadata implements Resource {
	@Id
	private String id;
	private String name;
	private Square square;

	public PictureMetadata(String name, Square square) {
		this.name = name;
		this.square = square;
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

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	@Override
	public String toString() {
		return "PictureMetadata{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", square=" + square +
				'}';
	}
}
