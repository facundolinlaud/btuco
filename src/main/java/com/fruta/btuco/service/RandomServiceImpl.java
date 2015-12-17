package com.fruta.btuco.service;

import com.fruta.btuco.model.PictureMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by facundo on 12/16/15.
 */
@Service
public class RandomServiceImpl implements RandomService {
    @Autowired
    private RandomPictureService randomPictureService;

    @Autowired
    private PictureCropService pictureCropService;

    @Autowired
    private PicturePathService picturePathService;

    @Override
    public String getPicture(Integer width, Integer height) {
        PictureMetadata picture = randomPictureService.getRandomPicture();

        if(width == null || height == null)
            return picturePathService.buildPicturePath(picture);
        else
            return pictureCropService.getCroppedPicturePath(picture, width, height);
    }
}
