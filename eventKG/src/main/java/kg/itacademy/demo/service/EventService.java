package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.model.CreateEventModel;

import java.util.List;

public interface EventService {
    Event save(Event event);
    Event save(CreateEventModel eventModel);
    Event findById(Long id);
    String deleteById(Long id);
    List<Event> getAllEvents();
    List<Event> getAllNewEventsByCategory(Long categoryId);
    List<Event> getAllTopEventsByCategory(Long categoryId);
    List<Event> getAllEventsByPartOfTitle(String name);
}
