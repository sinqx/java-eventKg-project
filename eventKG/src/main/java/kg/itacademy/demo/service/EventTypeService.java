package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventType;

import java.util.List;

public interface EventTypeService {
    EventType save(EventType eventType);
    EventType findById(Long id);
    List<EventType> getAllEventTypes();
}
