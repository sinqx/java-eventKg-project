package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.EventPhoto;
import kg.itacademy.demo.model.CreateEventPhotoModel;
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
    public EventPhoto save(@RequestBody CreateEventPhotoModel  eventPhotoModel){
        return eventPhotoService.save(eventPhotoModel);
    }

    @GetMapping("/{eventPhotoId}")
    public EventPhoto getById(@PathVariable Long eventPhotoId){
        return eventPhotoService.findById(eventPhotoId);
    }

    @DeleteMapping("/{eventPhotoId}")
    public EventPhoto deleteAllByEventId(@PathVariable Long eventPhotoId){
        return eventPhotoService.deleteAllByEventId(eventPhotoId);
    }

    @GetMapping("/event/{eventId}")
    public List<EventPhoto> getAllEventPhoto(@PathVariable Long eventId){
        return eventPhotoService.getAllEventPhoto(eventId);
    }
}
