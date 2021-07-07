package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.exception.ObjectNotFoundException;
import kg.itacademy.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
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
    public Guest saveView(Long eventId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(username);
        Event event = eventService.findById(eventId);
        if (guestRepository.findByUser_IdAndEventId(user.getId(), eventId) != null) {
           return null;
        } else {
            Guest guest = Guest.builder()
                    .event(event)
                    .user(user)
                    .status(false)
                    .build();
            event.setViews(event.getViews() + 1);
            eventService.save(event);
            return guestRepository.save(guest);
        }
    }

    @Override
    public Guest addGuest(Long eventId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(username);
        Guest guest = guestRepository.findByUser_IdAndEventId(user.getId(), eventId);
        guest.setStatus(!guest.getStatus());
        return save(guest);
    }

    @Override
    public Guest findById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Guest with id \"" + id + "\" doesn't exist"));
    }

    @Override
    public String deleteById(Long id) {
        Guest guest = findById(id);
        if (guest == null) {
            throw new ObjectNotFoundException("User with id \"" + id + "\" doesn't exist");
        } else {
            guestRepository.delete(guest);
            return "user with id \"" + id + "\" is deleted";
        }
    }

    @Override
    public List<Guest> findAllEventGuests(Long id) {
        List<Guest> guests = guestRepository.findAllByEvent_Id(id);
        if (guests.isEmpty()) {
            throw new ObjectNotFoundException("Nobody has decided to go to this event yet :( \n Be the first! Click \"I go!\"");
        } else
            return guests;
    }
}
