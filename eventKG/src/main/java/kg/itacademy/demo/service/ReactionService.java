package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Reaction;

public interface ReactionService {
    Reaction save(Reaction reaction);
    Reaction findById(Long id);
    Reaction deleteById(Long id);
}
