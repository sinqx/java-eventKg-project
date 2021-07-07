package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Guest;
import kg.itacademy.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping("/go/{eventId}")
    public void addGuest(@PathVariable Long eventId) {
        guestService.addGuest(eventId);
    }

    @PostMapping("/{eventId}")
    public Guest saveView(@PathVariable Long eventId) {
        return guestService.saveView(eventId);
    }

    @GetMapping("/{guestId}")
    public Guest getById(@PathVariable Long guestId) {
        return guestService.findById(guestId);
    }

    @DeleteMapping("/{guestId}")
    public String deleteById(@PathVariable Long guestId) {
        return guestService.deleteById(guestId);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity findAllEventGuests(@PathVariable Long eventId) {
        try {
            List<Guest> guests = guestService.findAllEventGuests(eventId);
            return new ResponseEntity<>(guests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
