package com.project.Dao;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.Entity.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PictureData {
    public static Map<Integer, Data> pictures;


    static {
        pictures = new HashMap<Integer, Data>() {
            {
                put(1, new Data(1, "cat.jpg"));

            }

        };
    }


    public Collection<Data> getAllPictures() {
        return this.pictures.values();
    }

    public Data getPictureById(int id) {
        return this.pictures.get(id);
    }

    public void removePictureById(int id) {
        this.pictures.remove(id);
    }
}
