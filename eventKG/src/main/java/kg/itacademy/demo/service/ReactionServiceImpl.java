package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Reaction;
import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.exception.ObjectNotFoundException;
import kg.itacademy.demo.model.CreateReactionModel;
import kg.itacademy.demo.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private PhotoService photoService;

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public Reaction save(CreateReactionModel reactionModel) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (reactionModel.getText() == null || reactionModel.getText().equals(" ")) {
            throw new ObjectNotFoundException("Please, write down your message");
        } else {
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
    }

    @Override
    public Reaction findById(Long id) {
        return reactionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Reaction with id \"" + id + "\" doesn't exist"));
    }

    @Override
    public List<Reaction> getAllReactions() {
        List<Reaction> reactions = reactionRepository.findAll();
        if (reactions.isEmpty()) {
            throw new ObjectNotFoundException("List is empty");
        } else
            return reactions;
    }

    @Override
    public List<Reaction> getAllEventReactions(Long eventId) {
        List<Reaction> reactions = reactionRepository.findAll();
        if (reactions.isEmpty()) {
            throw new ObjectNotFoundException("no one has left a comment yet :(. \n Be first! Write your comment right now!");
        } else
            return reactions;
    }

    @Override
    public List<Reaction> getAllUserReactions(String username) {
        List<Reaction> reactions = reactionRepository.findAll();
        if (reactions.isEmpty()) {
            throw new ObjectNotFoundException("You have not posted any comments yet.");
        } else
            return reactions;
    }

    @Override
    public Reaction deleteById(Long id) {
        Reaction reaction = findById(id);
        if (reaction == null) {
            throw new ObjectNotFoundException("Reaction with id \"" + id + "\" doesn't exist");
        } else {
            reactionRepository.delete(reaction);
            return reaction;
        }
    }
}
