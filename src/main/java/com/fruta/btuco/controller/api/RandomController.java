package com.fruta.btuco.controller.api;

import com.fruta.btuco.model.ActionParams;
import com.fruta.btuco.service.api.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Controller
@RequestMapping(value = "api/random")
public class RandomController {

    @Autowired
    private RandomService randomService;

    @RequestMapping(headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET)
    public @ResponseBody BufferedImage getRandomPicture(
            @RequestParam(value = "faceCoveragePercent", required = false) Integer faceCoveragePercent,
            @RequestParam(value = "pictureSize", required = false) Integer pictureSize,
            @RequestParam(value = "colorized", required = false) Boolean colorized) throws IOException {

        ActionParams params = new ActionParams(faceCoveragePercent, pictureSize, colorized);
        return randomService.getPicture(params);
    }
}