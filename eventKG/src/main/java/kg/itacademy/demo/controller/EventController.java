package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.model.CreateEventModel;
import kg.itacademy.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public Event save(@RequestBody CreateEventModel eventModel){
        return eventService.save(eventModel);
    }

    @GetMapping("/{eventId}")
    public Event getById(@PathVariable Long eventId){
        return eventService.findById(eventId);
    }

    @DeleteMapping("/{eventId}")
    public Event deleteById(@PathVariable Long eventId){
        return eventService.deleteById(eventId);
    }

    @GetMapping
    public List<Event> getAllEvents(){return eventService.getAllEvents();}

    @GetMapping("/like/{title}")
    public List<Event> getAllEventsByPartOfName(@PathVariable String title){return eventService.getAllEventsByPartOfName(title);}
}
