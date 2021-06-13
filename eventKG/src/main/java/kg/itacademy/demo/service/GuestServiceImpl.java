package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.model.CreateGuestModel;
import kg.itacademy.demo.repository.EventRepository;
import kg.itacademy.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest save(CreateGuestModel guestModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(username);
        Guest guest = Guest.builder()
                .event(eventService.findById(guestModel.getEventId()))
                .user(user)
                .build();
        return guestRepository.save(guest);
    }

    @Override
    public Guest findById(Long id) {
        return guestRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public Guest deleteById(Long id) {
        Guest guest = findById(id);
        if (guest != null) {
            guestRepository.delete(guest);
            return guest;
        }
        return null;// Вернуть исключение
    }

    @Override
    public List<Guest> findAllEventGuests(Long id) {
        return guestRepository.findAllByEvent_Id(id);
    }
}
