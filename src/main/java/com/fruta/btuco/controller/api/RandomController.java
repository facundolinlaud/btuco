package com.fruta.btuco.controller.api;

import com.fruta.btuco.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Controller
@RequestMapping(value = "api/random")
public class RandomController {

    @Autowired
    private RandomService randomService;

    @RequestMapping(headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET)
    public @ResponseBody BufferedImage getRandomPicture(@RequestParam(value = "width", required = false) Integer width, @RequestParam(value = "height", required = false) Integer height) throws IOException {
        String path = randomService.getPicture(width, height);
        InputStream inputStream = new FileInputStream(path);

        return ImageIO.read(inputStream);
    }
}
