package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.model.CreateReactionModel;
import kg.itacademy.demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @PostMapping
    public Reaction save(@RequestBody CreateReactionModel reactionModel){
        return reactionService.save(reactionModel);
    }

    @GetMapping("/{reactionId}")
    public Reaction getById(@PathVariable Long reactionId){
        return reactionService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public Reaction deleteById(@PathVariable Long reactionId){
        return reactionService.deleteById(reactionId);
    }

    @GetMapping
    public List<Reaction> getAllReactions() {
        return reactionService.getAllReactions();
    }

    @GetMapping("/eventReaction/{eventId}") //???????
    public List<Reaction> getAllEventReactions(@PathVariable Long eventId) {
        return reactionService.getAllEventReactions(eventId);
    }

    @GetMapping("/my")
    public List<Reaction> getAllUserReactions() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return reactionService.getAllUserReactions(name);
    }
}
