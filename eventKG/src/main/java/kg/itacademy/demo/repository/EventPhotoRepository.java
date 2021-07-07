package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.EventPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventPhotoRepository extends JpaRepository<EventPhoto, Long> {
    List<EventPhoto> findAllByEvent_Id(Long id);
    EventPhoto deleteAllByEventId(Long id);
}
