package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.EventType;
import kg.itacademy.demo.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventTypes")
public class EventTypeController {
    @Autowired
    private EventTypeService eventTypeService;

    @PostMapping
    public EventType save(@RequestBody EventType eventType){return eventTypeService.save(eventType);}

    @GetMapping
    public List<EventType> getAllEventTypes(){return eventTypeService.getAllEventTypes();}
}
