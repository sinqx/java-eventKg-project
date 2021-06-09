package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository  extends JpaRepository<Reaction, Long> {
}
