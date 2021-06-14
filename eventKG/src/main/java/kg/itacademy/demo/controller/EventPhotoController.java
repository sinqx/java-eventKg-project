package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.EventPhoto;
import kg.itacademy.demo.service.EventPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventPhotos")
public class EventPhotoController {
    @Autowired
    private EventPhotoService eventPhotoService;

    @PostMapping
    public EventPhoto save(@RequestBody EventPhoto eventPhoto){
        return eventPhotoService.save(eventPhoto);
    }

    @GetMapping("/{eventPhotoId}")
    public EventPhoto getById(@PathVariable Long eventPhotoId){
        return eventPhotoService.findById(eventPhotoId);
    }

    @DeleteMapping("/{eventPhotoId}")
    public EventPhoto deleteById(@PathVariable Long eventPhotoId){
        return eventPhotoService.deleteById(eventPhotoId);
    }

    @GetMapping("/event/{eventId}")
    public List<EventPhoto> getAllEventPhoto(@PathVariable Long eventId){
        return eventPhotoService.getAllEventPhoto(eventId);
    }
}
