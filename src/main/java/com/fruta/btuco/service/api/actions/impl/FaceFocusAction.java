package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.actions.Action;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by facundo on 12/17/15.
 */
public class FaceFocusAction extends DefaultAction{
    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        int futurePictureSize = params.getPictureSize();
        int futureFaceCoverage = params.getFaceCoveragePercent();
        float scale = (float) futurePictureSize / metadata.getSquare().getSize() * futureFaceCoverage / 100;

        return scale(image, scale);
    }

    private BufferedImage scale(BufferedImage before, float scale) {
        try {
            return Thumbnails.of(before).scale(scale).asBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
