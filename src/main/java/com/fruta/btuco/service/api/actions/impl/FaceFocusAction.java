package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.actions.Action;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/17/15.
 */
public class FaceFocusAction implements Action{
    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        int actualFaceWidth = metadata.getSquare().getWidth();
        int actualFaceHeight = metadata.getSquare().getHeight();

        return scale(image, params.getFaceWidth(), params.getFaceWidth(), actualFaceWidth, actualFaceHeight);
    }

    private BufferedImage scale(BufferedImage before, int desiredFaceWidth, int desiredFaceHeight, int actualFaceWidth, int actualFaceHeight){
        int w = before.getWidth();
        int h = before.getHeight();

        float xScale = (float) desiredFaceWidth / actualFaceWidth;
        float yScale = (float) desiredFaceHeight / actualFaceHeight;

        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);

        return scaleOp.filter(before, after);//.getSubimage(0, 0, desiredFaceWidth, desiredFaceHeight);
    }
}
