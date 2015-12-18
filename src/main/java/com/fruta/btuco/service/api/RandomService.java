package com.fruta.btuco.service.api;

import com.fruta.btuco.model.ActionParams;

import java.awt.image.BufferedImage;

/**
 * Created by facundo on 12/16/15.
 */
public interface RandomService {
    BufferedImage getPicture(ActionParams params);
}
