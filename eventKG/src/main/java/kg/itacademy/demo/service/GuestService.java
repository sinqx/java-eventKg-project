package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.model.CreateGuestModel;

import java.util.List;

public interface GuestService {
    Guest save(Guest guest);
    Guest save(Long eventId);
    String addGuest(Long eventId);
    Guest findById(Long id);
    Guest deleteById(Long id);
    List<Guest> findAllEventGuests(Long id);
}
