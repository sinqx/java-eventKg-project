package kg.itacademy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EventStatuses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_status", nullable = false)
    private String eventStatus;
}
