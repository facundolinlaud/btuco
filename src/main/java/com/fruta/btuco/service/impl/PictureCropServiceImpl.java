package com.fruta.btuco.service.impl;

import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.PictureCropService;
import com.fruta.btuco.service.PicturePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by facundo on 12/16/15.
 */
@Service
public class PictureCropServiceImpl implements PictureCropService {

    public static final String JPG = "jpg";
    private static final String PICTURE_CROPPING_ERROR = "error.jpg";

    @Autowired
    private PicturePathService picturePathService;

    @Override
    public String getCroppedPicturePath(PictureMetadata picture, int width, int height) {
        try {
            return createCroppedPicture(picture, width, height);
        } catch (IOException e) {
            e.printStackTrace();
            return PICTURE_CROPPING_ERROR;
        }
    }

    private String createCroppedPicture(PictureMetadata picture, int width, int height) throws IOException {
        int x = (int) picture.getCenter().getX();
        int y = (int) picture.getCenter().getY();

        BufferedImage image = ImageIO.read(new File(picturePathService.buildPicturePath(picture)));
        BufferedImage out = image.getSubimage(x - (width/2), y - (height/2), width, height);
        String croppedPicturePath = picturePathService.buildCroppedPicturePath();
        ImageIO.write(out, JPG, new File(croppedPicturePath));

        return croppedPicturePath;
    }
}
