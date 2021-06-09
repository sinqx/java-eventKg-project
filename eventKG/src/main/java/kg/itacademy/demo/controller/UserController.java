package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @GetMapping("/get-name")
    public String getName(Principal principal){
        return principal.getName();
    }

    @DeleteMapping("/{userId}")
    public User deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }
}
