package com.fruta.btuco.service;

import com.fruta.btuco.model.PictureMetadata;

/**
 * Created by facundo on 12/16/15.
 */
public interface PicturePathService {
    String getPicturesPath();

    String buildPicturePath(PictureMetadata picture);

    String getCroppedPicturesPath();

    String buildCroppedPicturePath();
}
