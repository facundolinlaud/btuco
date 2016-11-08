package com.fruta.btuco.service.api.actions.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.actions.Action;

import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/20/15.
 */
public abstract class DefaultAction implements Action {
    private static final int MAX_PICTURE_SIZE_IN_PX = 1024;

    @Override
    public boolean requiredParametersExist(ActionParams actionParams) {
        int size = actionParams.getPictureSize();

        if(size > 0 && size <= MAX_PICTURE_SIZE_IN_PX && actionParams.getFaceCoveragePercent() > 0){
            return true;
        }

        return false;
    }

    @Override
    public BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params) {
        return null;
    }
}
