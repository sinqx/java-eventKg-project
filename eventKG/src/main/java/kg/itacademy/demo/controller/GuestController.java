package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public Guest save(@RequestBody Guest guest){
        return guestService.save(guest);
    }

    @GetMapping("/{eventId}")
    public Guest getById(@PathVariable Long guestId){
        return guestService.findById(guestId);
    }

    @DeleteMapping("/{eventId}")
    public Guest deleteById(@PathVariable Long guestId){
        return guestService.deleteById(guestId);
    }

    // Поиск всех гостей по ид ивента
}
