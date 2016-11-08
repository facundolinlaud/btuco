package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.model.Square;
import com.fruta.btuco.service.api.actions.Action;

import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/17/15.
 */
public class PictureCropAction extends DefaultAction {
    private static final int MAX_PICTURE_SIZE_IN_PX = 1024;

    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        int futurePictureSize = params.getPictureSize();
        int futureFaceCoverage = params.getFaceCoveragePercent();

        float scale = (float) futurePictureSize / metadata.getSquare().getSize() * futureFaceCoverage / 100;
        int offset = (int)((futurePictureSize - (metadata.getSquare().getSize() * scale)) / 2);

        Square square = metadata.getSquare();
        int x = (int)(square.getStartX() * scale) - offset;
        int y = (int)(square.getStartY() * scale) - offset;

        return crop(image, x, y, futurePictureSize);
    }

    private BufferedImage crop(BufferedImage before, int x, int y, int desiredSize){
        if(x < 0) x = 0;
        if(y < 0) y = 0;

        int minimum = before.getWidth();
        int imageHeight = before.getHeight();

        if(minimum > imageHeight){
            minimum = imageHeight;
        }

        if(desiredSize > minimum){
            desiredSize = minimum;
        }


        return before.getSubimage(x, y, desiredSize, desiredSize);
    }
}
