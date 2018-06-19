package com.project.Entity;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.project.Dao.PictureData.pictures;

public class Data {
    private int index;
    private String fileName;
    private int width;
    private int height;
    int size;

    public Data(int index, String fileName, int width, int height, int size) {
        this.index = index;
        this.fileName = fileName;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public Data(int index, String fileName) {
        this.index = index;
        this.fileName = fileName;
        this.width = 0;
        this.height = 0;
        this.size = 0;

    }

    public ResponseEntity<byte[]> getPictureById(int id) throws IOException{
        String name = pictures.get(id).getFileName();
        File imagePath=new File("\\\\KRYWAN\\RedirectedUserFolders\\emackiew\\Pulpit\\pictures"+name+".jpg");

        byte[]image= Files.readAllBytes(imagePath.toPath());
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return  new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    public Data(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
