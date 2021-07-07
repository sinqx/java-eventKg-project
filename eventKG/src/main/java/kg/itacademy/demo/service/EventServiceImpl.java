package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.exception.EventException;
import kg.itacademy.demo.exception.ObjectNotFoundException;
import kg.itacademy.demo.model.CreateEventModel;
import kg.itacademy.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventStatusService eventStatusService;
    @Autowired
    private EventTypeService eventTypeService;
    @Autowired
    private EventPhotoService eventPhotoService;
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event save(CreateEventModel eventModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(username);
        Event checkEvent = eventRepository.findByCreatorUserIdAndEventStatus(user.getId(), eventStatusService.findById(1L));

        if (checkEvent != null) {
            throw new EventException("You can't create the event, until your previously is not finished!");
        } else if (eventModel.getDescription() == null || eventModel.getEventTypeId() == null ||
                eventModel.getTitle() == null || eventModel.getStartDate() == null) {
            throw new EventException("Please fill in all required fields");
        } else {
            Event event = Event.builder()
                    .creatorUser(user)
                    .mainPhoto(photoService.findById(eventModel.getMainPhotoId()))
                    .title(eventModel.getTitle())
                    .description(eventModel.getDescription())
                    .views((long) 0)
                    .creationDate(LocalDateTime.now())
                    .startDate(eventModel.getStartDate())
                    .endDate(eventModel.getStartDate().plusDays(1))
                    .eventStatus(eventStatusService.findById(1L))
                    .eventType(eventTypeService.findById(eventModel.getEventTypeId()))
                    .build();
            return eventRepository.save(event);
        }
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Event with id \"" + id + "\" doesn't exist"));
    }

    @Override
    public String deleteById(Long id) {
        Event event = findById(id);
        if (event == null) {
            throw new ObjectNotFoundException("User with id \"" + id + "\" doesn't exist");
        } else {
            eventPhotoService.deleteAllByEventId(id);
            eventRepository.delete(event);
            return "user with id \"" + id + "\" is deleted";
        }
    }

    @Override
    public List<Event> getAllEvents() {
        try {
            return eventRepository.findAll();
        } catch (NullPointerException ignored) {
            throw new ObjectNotFoundException("List is empty");
        }
    }

    @Override
    public List<Event> getAllEventsByCategory(Long categoryId) {
        try {
            return eventRepository.findByEventTypeIdOrderByCreationDate(categoryId);
        } catch (NullPointerException ignored) {
            throw new ObjectNotFoundException("List is empty :(.\n" +
                    " Be the first, who create the event in" + eventStatusService.findById(categoryId) + "category!");
        }
    }

    @Override
    public List<Event> getAllEventsByPartOfTitle(String title) {
        try {
            return eventRepository.findByTitleContainingIgnoringCaseOrderByCreationDate(title);
        } catch (NullPointerException ignored) {
            throw new ObjectNotFoundException("No related events found");
        }
    }
}
