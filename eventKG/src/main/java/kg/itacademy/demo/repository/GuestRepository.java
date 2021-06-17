package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{
    List<Guest> findAllByEvent_Id(Long id);
    Guest findByUser_Id(Long id);
}
