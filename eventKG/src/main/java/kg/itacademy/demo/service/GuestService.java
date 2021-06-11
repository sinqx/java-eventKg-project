package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Guest;

public interface GuestService {
    Guest save(Guest guest);
    Guest findById(Long id);
    Guest deleteById(Long id);
}
