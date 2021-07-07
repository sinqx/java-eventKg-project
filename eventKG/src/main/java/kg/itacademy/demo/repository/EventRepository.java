package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.entity.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTitleContainingIgnoringCaseOrderByCreationDate(String title);
    List<Event> findByEventTypeIdOrderByCreationDate(Long categoryId);
    List<Event> findByEventTypeIdOrderByViews(Long categoryId);
    Event findByCreatorUserIdAndEventStatus(Long id, EventStatus status);
}
