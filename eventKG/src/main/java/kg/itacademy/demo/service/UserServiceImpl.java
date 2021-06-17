package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.entity.UserRole;
import kg.itacademy.demo.exception.AuthException;
import kg.itacademy.demo.model.AuthModel;
import kg.itacademy.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User saveWithPasswordEncode(User user){
        Optional<User> userLoginCheck = userRepository.findByFullName(user.getFullName());
        Optional<User> userEmailCheck = userRepository.findByEmail(user.getEmail());

        if (userLoginCheck.isPresent()) {
            throw new AuthException("Такой логин уже существует");
        } else if (userEmailCheck.isPresent()) {
            throw new AuthException("Введите другой Email");
        } else {
            user.setCreationDate(LocalDateTime.now());
            user.setStatus((long) 1);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = userRepository.save(user);
            UserRole userRole = new UserRole();
            userRole.setRoleName("ROLE_USER");
            userRole.setUser(user);
            userRoleService.save(userRole);
            return user;
        }
    }

    @Override
    public User findByLogin(String username) {
        return userRepository.findByLogin(username).orElse(null);// Вернуть исключение и доделать
    }

    @Override
    public String getTokenByAuthModel(AuthModel authModel) {
        String authResult = "";
        User user = findByLogin(authModel.getLogin());
        if (user == null) authResult = "Неверный логин/пароль";
        else {
            if (passwordEncoder.matches(authModel.getPassword(), user.getPassword())) {
                String loginPassPair = user.getLogin() + ":" + authModel.getPassword();
                authResult = "Basic " + Base64.getEncoder().encodeToString(loginPassPair.getBytes());
            } else authResult = "Неверный логин/пароль";
        }
        return authResult;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            System.out.println("Пользователь: " + SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (NullPointerException ignored)
        {
            System.out.println("null");
        }

        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    } // Вернуть исключение


    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;// Вернуть исключение
    }

    @Override
    public List<User> findUsersByPartOfFullName(String name) {
        return userRepository.findByFullNameContainingIgnoringCase(name);
    }
}
