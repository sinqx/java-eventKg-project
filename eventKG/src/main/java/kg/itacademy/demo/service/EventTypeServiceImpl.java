package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventType;
import kg.itacademy.demo.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventTypeServiceImpl implements EventTypeService {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public EventType findById(Long id) {
        return eventTypeRepository.findById(id).orElse(null);
    }
}
