package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.actions.Action;

import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/17/15.
 */
public class PictureCropAction implements Action {
    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        int futurePictureSize = params.getPictureSize();
        int futureFaceCoverage = params.getFaceCoveragePercent();
        float scale = (float) futurePictureSize / metadata.getSquare().getSize() * futureFaceCoverage / 100;

        int offset = (int)((futurePictureSize - (metadata.getSquare().getSize() * scale)) / 2);
        int x = (int)(metadata.getSquare().getStartX() * scale) - offset;
        int y = (int)(metadata.getSquare().getStartY() * scale) - offset;

        return crop(image, x, y, futurePictureSize);
    }

    private BufferedImage crop(BufferedImage before, int x, int y, int desiredSize){
        return before.getSubimage(x, y, desiredSize, desiredSize);
    }
}
