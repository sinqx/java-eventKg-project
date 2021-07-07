package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity getById(@PathVariable Long userId) {
        try {
            User user =  userService.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/get-name")
    public String getName(Principal principal) {
        return principal.getName();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteById(@PathVariable Long userId) {
        try {
            String answer = userService.deleteById(userId);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity findUsersByPartOfFullName(@PathVariable String name) {
        try {
            List<User> users = userService.findUsersByPartOfFullName(name);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/changeStatus/{userId}")
    public ResponseEntity changeStatusById(@PathVariable Long userId){
        try {
            User user = userService.changeStatusById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
