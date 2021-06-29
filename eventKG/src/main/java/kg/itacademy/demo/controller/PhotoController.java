package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo save(@RequestParam(name = "file") MultipartFile multipartFile){
        System.out.println("test1");
        return photoService.save(multipartFile);
    }

    @GetMapping("/{photoId}")
    public Photo getById(@PathVariable Long photoId){
        return photoService.findById(photoId);
    }

    @DeleteMapping("/{photoId}")
    public Photo deleteById(@PathVariable Long photoId){
        return photoService.deleteById(photoId);
    }
}
