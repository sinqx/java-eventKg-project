package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl implements ReactionService{
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction); // ???????
    }

    @Override
    public Reaction findById(Long id) {
        return reactionRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public Reaction deleteById(Long id) {
        Reaction reaction = findById(id);
        if (reaction != null) {
            reactionRepository.delete(reaction);
            return reaction;
        }
        return null;// Вернуть исключение
    }
}
