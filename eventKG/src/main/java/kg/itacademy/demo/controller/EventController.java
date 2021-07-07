package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.model.CreateEventModel;
import kg.itacademy.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateEventModel eventModel) {
        try {
            Event event = eventService.save(eventModel);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/{eventId}")
    public ResponseEntity findById(@PathVariable Long eventId) {
        try {
            Event event = eventService.findById(eventId);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity deleteById(@PathVariable Long eventId) {
        try {
            String answer = eventService.deleteById(eventId);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getAllEvents() {
        try {
            List<Event> events = eventService.getAllEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{title}")
    public ResponseEntity getAllEventsByPartOfTitle(@PathVariable String title) {
        try {
            List<Event> events = eventService.getAllEventsByPartOfTitle(title);
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/new/{categoryId}")
    public ResponseEntity getAllNewEventsByCategory(@PathVariable Long categoryId) {
        try {
            List<Event> events = eventService.getAllNewEventsByCategory(categoryId);
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
    @GetMapping("/top/{categoryId}")
    public ResponseEntity getAllTopEventsByCategory(@PathVariable Long categoryId) {
        try {
            List<Event> events = eventService.getAllTopEventsByCategory(categoryId);
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
