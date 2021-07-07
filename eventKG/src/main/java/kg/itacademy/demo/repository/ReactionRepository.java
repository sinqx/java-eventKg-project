package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository  extends JpaRepository<Reaction, Long> {
    List<Reaction> findAllByUserId(Long id);
    List<Reaction> findAllByEvent_Id(Long id);
}
