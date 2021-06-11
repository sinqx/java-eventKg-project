package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event); //??????
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public Event deleteById(Long id) {
        Event event = findById(id);
        if (event != null) {
            eventRepository.delete(event);
            return event;
        }
        return null;// Вернуть исключение
    }
}
