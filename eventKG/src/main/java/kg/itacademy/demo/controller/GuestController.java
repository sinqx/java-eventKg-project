package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.model.AuthModel;
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

    @PostMapping("/go/{eventId}")
    public String addGuest(@PathVariable Long eventId){return guestService.addGuest(eventId);}

    @PostMapping("/{eventId}")
    public Guest addView(@PathVariable Long eventId){
        return guestService.save(eventId);
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
