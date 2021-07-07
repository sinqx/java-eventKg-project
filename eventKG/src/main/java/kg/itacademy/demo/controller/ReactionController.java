package kg.itacademy.demo.controller;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.model.CreateReactionModel;
import kg.itacademy.demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateReactionModel reactionModel) {
        try {
            Reaction reaction = reactionService.save(reactionModel);
            return new ResponseEntity<>(reaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/{reactionId}")
    public Reaction getById(@PathVariable Long reactionId) {
        return reactionService.findById(reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public Reaction deleteById(@PathVariable Long reactionId) {
        return reactionService.deleteById(reactionId);
    }

    @GetMapping
    public ResponseEntity getAllReactions() {
        try {
            List<Reaction> reactions = reactionService.getAllReactions();
            return new ResponseEntity<>(reactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/eventReaction/{eventId}")
    public ResponseEntity getAllEventReactions(@PathVariable Long eventId) {
        try {
            List<Reaction> reactions = reactionService.getAllEventReactions(eventId);
            return new ResponseEntity<>(reactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping("/my")
    public ResponseEntity getAllUserReactions() {
        try {
            List<Reaction> reactions = reactionService.getAllUserReactions();
            return new ResponseEntity<>(reactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
