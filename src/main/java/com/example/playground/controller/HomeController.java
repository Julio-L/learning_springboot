package com.example.playground.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String welcome(){
        return "Welcome";
    }

    //Testing sending images to client and how classpathresource works
    @GetMapping(value="/image-from-other-dir", produces = MediaType.IMAGE_JPEG_VALUE)
    public void image(HttpServletResponse response){
        try {
            InputStream is = new ClassPathResource("static/sky.jpeg").getInputStream();
            IOUtils.copy(is,response.getOutputStream());
        } catch(FileNotFoundException e){
            response.setStatus(400);
        }catch (IOException e) {
            response.setStatus(400);
        }

    }

}
