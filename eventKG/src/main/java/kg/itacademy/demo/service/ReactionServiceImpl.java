package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.model.CreateReactionModel;
import kg.itacademy.demo.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService{
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private PhotoService photoService;

    @Override
    public Reaction save(Reaction reaction) { return reactionRepository.save(reaction); }

    @Override
    public Reaction save(CreateReactionModel reactionModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName(); // Логин или имя?
        User user = userService.findByLogin(username);
        Reaction reaction = Reaction.builder()
                .user(user)
                .event(eventService.findById(reactionModel.getEventId()))
                .text(reactionModel.getText())
                .publicationDate(LocalDateTime.now())
                .photo(photoService.findById(reactionModel.getPhotoId()))
                .build();
        return reactionRepository.save(reaction);
    }

    @Override
    public Reaction findById(Long id) {
        return reactionRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public List<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    @Override
    public List<Reaction> getAllEventReactions(Long eventId) {
        return reactionRepository.findAllByEvent_Id(eventId);
    }

    @Override
    public List<Reaction> getAllUserReactions(String username) {
        User user = userService.findByLogin(username);
        String name = user.getFullName();
        return reactionRepository.findAllByUser_FullName(name);
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
