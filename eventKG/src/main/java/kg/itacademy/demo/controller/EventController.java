package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public Event save(@RequestBody Event event){
        return eventService.save(event);
    }

    @GetMapping("/{eventId}")
    public Event getById(@PathVariable Long eventId){
        return eventService.findById(eventId);
    }

    @DeleteMapping("/{eventId}")
    public Event deleteById(@PathVariable Long eventId){
        return eventService.deleteById(eventId);
    }
}
