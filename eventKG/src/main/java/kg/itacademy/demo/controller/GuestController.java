package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.model.CreateGuestModel;
import kg.itacademy.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping
    public Guest save(@RequestBody CreateGuestModel guestModel){
        return guestService.save(guestModel);
    }

    @GetMapping("/{guestId}")
    public Guest getById(@PathVariable Long guestId){
        return guestService.findById(guestId);
    }

    @DeleteMapping("/{guestId}")
    public Guest deleteById(@PathVariable Long guestId){
        return guestService.deleteById(guestId);
    }

    @GetMapping("/event/{eventId}")
    public List<Guest> findAllEventGuests(@PathVariable Long eventId){ return guestService.findAllEventGuests(eventId); }
}
