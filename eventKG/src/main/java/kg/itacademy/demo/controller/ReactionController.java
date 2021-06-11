package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @GetMapping
    public Reaction save(@RequestBody Reaction reaction){
        return reactionService.save(reaction);
    }

    @GetMapping("/{reactionId}")
    public Reaction getById(@PathVariable Long reactionId){
        return reactionService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public Reaction deleteById(@PathVariable Long reactionId){
        return reactionService.deleteById(reactionId);
    }

    // + Все реакции определённого ивента
}
