package com.fruta.btuco.service.api.actions;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;

import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/17/15.
 */
public interface Action {
    BufferedImage apply(PictureMetadata metadata, BufferedImage image, ActionParams params);

    boolean requiredParametersExist(ActionParams actionParams);
}
