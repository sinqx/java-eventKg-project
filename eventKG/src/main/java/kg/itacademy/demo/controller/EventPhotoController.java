package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.EventPhoto;
import kg.itacademy.demo.service.EventPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventPhotos")
public class EventPhotoController {
    @Autowired
    private EventPhotoService eventPhotoService;

    @GetMapping
    public EventPhoto save(@RequestBody EventPhoto eventPhoto){
        return eventPhotoService.save(eventPhoto);
    }

    @GetMapping("/{eventId}")
    public EventPhoto getById(@PathVariable Long eventPhotoId){
        return eventPhotoService.findById(eventPhotoId);
    }

    @DeleteMapping("/{eventId}")
    public EventPhoto deleteById(@PathVariable Long eventPhotoId){
        return eventPhotoService.deleteById(eventPhotoId);
    }

    // Получить все фотки ивента
}
