package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public Photo save(@RequestBody Photo photo){
        return photoService.save(photo);
    }

    @GetMapping("/{photoId}")
    public Photo getById(@PathVariable Long photoId){
        return photoService.findById(photoId);
    }

    @DeleteMapping("/{photoId}")
    public Photo deleteById(@PathVariable Long photoId){
        return photoService.deleteById(photoId);
    }

    //Получить все фотки определённого ивента
}
