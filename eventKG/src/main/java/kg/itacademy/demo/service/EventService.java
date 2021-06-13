package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.model.CreateEventModel;

import java.util.List;

public interface EventService {
    Event save(Event event);
    Event save(CreateEventModel eventModel);
    Event findById(Long id);
    Event deleteById(Long id);
    List<Event> getAllEvents();
}
