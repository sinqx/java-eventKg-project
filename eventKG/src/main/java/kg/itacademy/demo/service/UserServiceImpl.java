package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.model.AuthModel;
import kg.itacademy.demo.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private userRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private UserRoleService userRoleService;



    @Override
    public User saveWithPasswordEncode(User user){
//        Optional<User> userLoginCheck = userRepository.findByPartOfFullName(user.getFullName());
//        Optional<User> userEmailCheck = userRepository.findByEmail(user.getEmail());
//
//        if (userLoginCheck.isPresent()) {
//            throw new AuthException("Такой логин уже существует");
//        } else if (userEmailCheck.isPresent()) {
//            throw new AuthException("Введите другой Email");
//        } else {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            user = userRepository.save(user);
//            UserRole userRole = new UserRole();
//            userRole.setRoleName("ROLE_USER");
//            userRole.setUser(user);
//            userRoleService.save(userRole);
//            return user;
//        }
    }

    @Override
    public User findByPartOfFullName(String username) {
        return userRepository.findByPartOfFullName(username).orElse(null);
    }

    @Override
    public String getTokenByAuthModel(AuthModel authModel) {
        return null;
    }

//    @Override
//    public String getTokenByAuthModel(AuthModel authModel) {
//        String authResult = "";
//        User user = findByPartOfFullName(authModel.getFullName());
//        if (user == null) authResult = "Неверный логин/пароль";
//        else {
//            if (passwordEncoder.matches(authModel.getPassword(), user.getPassword())) {
//                String loginPassPair = user.getUsername() + ":" + authModel.getPassword();
//                authResult = "Basic " + Base64.getEncoder().encodeToString(loginPassPair.getBytes());
//            } else authResult = "Неверный логин/пароль";
//        }
//        return authResult;
//    }

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
    }


    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> deleteAllUsers() {
        List<User> user = getAllUsers();
        if (user != null) {
            userRepository.deleteAll(user);
        }
        return null;
    }
}
