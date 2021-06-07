package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<User, Long> {
    Optional<User> findByPartOfFullName(String username);
}