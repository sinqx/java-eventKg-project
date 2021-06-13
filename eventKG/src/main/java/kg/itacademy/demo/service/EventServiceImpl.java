package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.model.CreateEventModel;
import kg.itacademy.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventStatusService eventStatusService;
    @Autowired
    private EventTypeService eventTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event); //??????
    }

    @Override
    public Event save(CreateEventModel eventModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(username);
        Event event = Event.builder()
                .creatorUser(user)
                .mainPhoto(photoService.findById(eventModel.getMainPhotoId()))
                .title(eventModel.getTitle())
                .description(eventModel.getDescription())
                .views(eventModel.getViews())
                .creationDate(LocalDateTime.now())
                .startDate(eventModel.getStartDate())
                .endDate(eventModel.getEndDate())
                .eventStatus(eventStatusService.findById(eventModel.getEventStatusId()))
                .eventType(eventTypeService.findById(eventModel.getCreatorId()))
                .build();
        return eventRepository.save(event);
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

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
