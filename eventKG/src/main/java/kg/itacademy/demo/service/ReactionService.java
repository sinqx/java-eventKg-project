package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.model.CreateReactionModel;

import java.util.List;

public interface ReactionService {
    Reaction save(Reaction reaction);
    Reaction save(CreateReactionModel reactionModel);
    Reaction findById(Long id);
    Reaction deleteById(Long id);
    List<Reaction> getAllReactions();
    List<Reaction> getAllEventReactions(Long eventId);
    List<Reaction> getAllUserReactions(String name);
}
