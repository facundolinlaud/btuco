package com.fruta.btuco.service;

import com.fruta.btuco.model.PictureMetadata;

/**
 * Created by facundo on 12/16/15.
 */
public interface PictureCropService {
    String getCroppedPicturePath(PictureMetadata picture, int width, int height);
}
