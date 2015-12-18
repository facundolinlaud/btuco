package com.fruta.btuco.transformer.impl;

import com.fruta.btuco.model.Picture;
import com.fruta.btuco.model.Square;
import com.fruta.btuco.transformer.TriadicTransformer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class PicturesTransformer implements TriadicTransformer<List<MultipartFile>, List<Square>, List<Picture>> {

	@Override
	public List<Picture> transform(List<MultipartFile> files, List<Square> squares) {
		List<Picture> pictures = new ArrayList<Picture>();

		for (int i = 0; i < files.size(); i++) {
			pictures.add(new Picture(files.get(i), squares.get(i)));
		}

		return pictures;
	}
}
