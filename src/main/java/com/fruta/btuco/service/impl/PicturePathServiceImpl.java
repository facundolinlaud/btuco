package com.fruta.btuco.service.impl;

import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.PicturePathService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by facundo on 12/16/15.
 */
@Service
public class PicturePathServiceImpl implements PicturePathService{

    private static final String CROPPED_PICTURES_FOLDER = "tmp";

    @Value("${pictures.directory}")
    private String picturesDirectory;

    @Override
    public String getPicturesPath() {
        return picturesDirectory;
    }

    @Override
    public String buildPicturePath(PictureMetadata picture) {
        return picturesDirectory + picture.getName();
    }

    @Override
    public String getCroppedPicturesPath() {
        return picturesDirectory + CROPPED_PICTURES_FOLDER;
    }

    @Override
    public String buildCroppedPicturePath() {
        return getCroppedPicturesPath() + "/" + new Timestamp(System.currentTimeMillis());
    }
}
