package com.fruta.btuco.service.api.impl;

import com.fruta.btuco.dao.PicturesDao;
import com.fruta.btuco.model.PictureMetadata;
import com.fruta.btuco.service.api.RandomPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by facundo on 12/16/15.
 */
@Service
public class RandomPictureServiceImpl implements RandomPictureService {

    @Autowired
    private PicturesDao picturesDao;

    @Override
    public PictureMetadata getRandomPicture(){
        return getRandomPicture(picturesDao.findAll());
    }

    private PictureMetadata getRandomPicture(List<PictureMetadata> pictures){
        return pictures.get(getRandomNumber(pictures.size()));
    }

    private int getRandomNumber(int to){
        Random r = new Random();
        return r.nextInt(to);
    }
}
