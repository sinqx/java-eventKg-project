package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventStatus;
import kg.itacademy.demo.repository.EventStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventStatusServiceImpl implements EventStatusService{
    @Autowired
    private EventStatusRepository eventStatusRepository;

    @Override
    public EventStatus findById(Long id) {
        return eventStatusRepository.findById(id).orElse(null);
    }
}
