package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Guest;

import java.util.List;

public interface GuestService {
    Guest save(Guest guest);
    Guest saveView(Long eventId);
    Guest addGuest(Long eventId);
    Guest findById(Long id);
    String deleteById(Long id);
    List<Guest> findAllEventGuests(Long id);
}
