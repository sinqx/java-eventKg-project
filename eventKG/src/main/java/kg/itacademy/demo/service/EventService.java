package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;

public interface EventService {
    Event save(Event event);
    Event findById(Long id);
    Event deleteById(Long id);
}
