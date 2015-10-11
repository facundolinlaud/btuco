package com.fruta.btuco.transformer.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fruta.btuco.model.Picture;
import com.fruta.btuco.transformer.TriadicTransformer;

@Service
public class PicturesTransformer implements TriadicTransformer<List<MultipartFile>, List<String>, List<Picture>> {

	@Override
	public List<Picture> transform(List<MultipartFile> files, List<String> centers) {
		List<Picture> pictures = new ArrayList<Picture>();

		for (int i = 0; i < files.size(); i++) {
			pictures.add(new Picture(files.get(i), buildPoint(centers.get(i))));
		}

		return pictures;
	}

	private Point buildPoint(String strPoint) {
		String[] coords = strPoint.split(";");

		int x = Integer.parseInt(coords[0]);
		int y = Integer.parseInt(coords[1]);

		return new Point(x, y);
	}
}
