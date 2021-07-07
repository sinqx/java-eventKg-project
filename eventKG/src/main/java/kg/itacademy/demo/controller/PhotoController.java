package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping
    public ResponseEntity save(@RequestParam(name = "file") MultipartFile multipartFile){
        try {
            Photo photo = photoService.save(multipartFile);
            return new ResponseEntity<>(photo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/{photoId}")
    public ResponseEntity getById(@PathVariable Long photoId){
        try {
            Photo photo = photoService.findById(photoId);
            return new ResponseEntity<>(photo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{photoId}")
    public ResponseEntity deleteById(@PathVariable Long photoId){
        try {
            String answer = photoService.deleteById(photoId);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getAllPhotos(){
        try {
            List<Photo> photos = photoService.getAllPhotos();
            return new ResponseEntity<>(photos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
