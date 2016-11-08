package com.fruta.btuco.service.api.impl;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.FileService;
import com.fruta.btuco.service.api.RandomPictureService;
import com.fruta.btuco.service.api.RandomService;
import com.fruta.btuco.service.api.actions.Action;
import com.fruta.btuco.service.api.actions.impl.FaceFocusAction;
import com.fruta.btuco.service.api.actions.impl.ColorizedAction;
import com.fruta.btuco.service.api.actions.impl.PictureCropAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * Created by facundo on 12/16/15.
 */
@Service
public class RandomServiceImpl implements RandomService {
    @Autowired
    private RandomPictureService randomPictureService;

    @Autowired
    private FileService fileService;

    private List<Action> actions = Arrays.asList(new FaceFocusAction(), new PictureCropAction(), new ColorizedAction());

    @Override
    public BufferedImage getPicture(ActionParams params) {
        PictureMetadata metadata = randomPictureService.getRandomPicture();
        BufferedImage image = fileService.getImage(metadata);

        for(Action action : actions){
            if(action.requiredParametersExist(params)){
                image = action.apply(metadata, image, params);
            }
        }

        return image;
    }
}