package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Entity.Data;
import com.project.Dao.PictureData;

import java.io.IOException;
import java.util.Collection;

@Service
public class PictureService {
    @Autowired
    public PictureData getData;

    public Collection<Data> getAllPictures(){
        return this.getData.getAllPictures();
    }

    public Data getPictureById(int id) {
        return this.getData.getPictureById(id);
    }

    public void removePictureById(int id) {
        this.getData.removePictureById(id);
    }
}
