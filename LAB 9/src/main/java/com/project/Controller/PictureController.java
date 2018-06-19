package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.Entity.Data;
import com.project.Service.PictureService;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureService dataService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Data> getAllPictures(){
        return dataService.getAllPictures();
    }

   /* @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Data getPicturesById(@PathVariable("id") int id){
        return dataService.getPictureById(id);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePictureById(@PathVariable("id") int id){
        if(dataService.getPictureById(id) == null){
            return "{result:false}";
        }
        else {
            dataService.removePictureById(id);
            return "{result:true}";
        }
    }

    @RequestMapping(value = "/{id}", method =RequestMethod.GET)
    @ResponseBody
    public Data getPicturesById(@PathVariable("id")int id) throws IOException {
        return dataService.getPictureById(id);
    }


    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void getPicturesById(@PathVariable("id") int id, HttpServletResponse response) throws  IOException {
        ClassPathResource imgFile = new ClassPathResource("C:\\Users\\Patryk\\Desktop\\Java_GR3_Kluz_15-05\\src\\main\\resources\\images\\"+dataService.getData.pictures.get(id).getFileName());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }*/
}
