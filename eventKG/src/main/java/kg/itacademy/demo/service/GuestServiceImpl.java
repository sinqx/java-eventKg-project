package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.repository.EventRepository;
import kg.itacademy.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Guest save(Guest guest) {
        Guest guest1 = new Guest();
        Event event = eventRepository.findById((long)2).orElse(null);;
        guest1.setEvent(event); //??
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
}
