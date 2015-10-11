package com.fruta.btuco.dao.impl;

import org.springframework.stereotype.Repository;

import com.fruta.btuco.dao.PicturesDao;
import com.fruta.btuco.model.PictureMetadata;

@Repository("picturesDao")
public class PicturesDaoImpl extends GenericDaoImpl<PictureMetadata> implements PicturesDao {

	protected PicturesDaoImpl() {
		super(PictureMetadata.class);
	}
}
