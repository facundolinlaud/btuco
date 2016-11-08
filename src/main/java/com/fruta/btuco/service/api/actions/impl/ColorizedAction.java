package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.actions.Action;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/20/15.
 */
public class ColorizedAction implements Action {
    private static final Color WHATEVER_COLOR;

    static {
        WHATEVER_COLOR = new Color(50, 50, 100, 100);
    }

    @Override
    public boolean requiredParametersExist(ActionParams actionParams) {
        return actionParams.isColorized();
    }

    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        Graphics g = image.getGraphics();
        g.setColor(WHATEVER_COLOR);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.dispose();

        return image;
    }
}
