package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.User;
import kg.itacademy.demo.model.AuthModel;

import java.util.List;

public interface UserService {
    User saveWithPasswordEncode(User user) throws Exception;
    List<User> getAllUsers();
    User findById(Long id);
    User findByPartOfFullName(String username);
    String getTokenByAuthModel(AuthModel authModel);
    User deleteById(Long id);
    List<User> deleteAllUsers();
}
