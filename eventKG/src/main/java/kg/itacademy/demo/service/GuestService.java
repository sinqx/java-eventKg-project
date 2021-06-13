package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.model.CreateGuestModel;

import java.util.List;

public interface GuestService {
    Guest save(CreateGuestModel guestModel);
    Guest save(Guest guest);
    Guest findById(Long id);
    Guest deleteById(Long id);
    List<Guest> findAllEventGuests(Long id);
}
