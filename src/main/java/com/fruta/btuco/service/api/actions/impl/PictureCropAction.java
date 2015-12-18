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
        int w = params.getPictureWidth();
        int h = params.getPictureHeight();

        Integer faceWidth = params.getFaceWidth();
        if(faceWidth != null) w += faceWidth;

        Integer faceHeight = params.getFaceHeight();
        if(faceHeight != null) h += faceHeight;

        int x = (w - faceWidth) / 2;
        int y = (h - faceHeight) / 2;

        return crop(image, x, y, w, h);
    }

    private BufferedImage crop(BufferedImage before, int x, int y, int desiredWidth, int desiredHeight){
        return before.getSubimage(x, y, desiredWidth, desiredHeight);
    }
}
