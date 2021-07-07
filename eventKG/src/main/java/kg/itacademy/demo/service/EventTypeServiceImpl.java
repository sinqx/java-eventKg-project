package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventType;
import kg.itacademy.demo.exception.ObjectNotFoundException;
import kg.itacademy.demo.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public EventType save(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public EventType findById(Long id) {
        return eventTypeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Type with id \"" + id + "\" doesn't exist"));
    }

    @Override
    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }
}
