package kg.itacademy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EventPhotos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "photo_id", nullable = false, unique = true)
    @ManyToOne
    private Photo photo;

    @JoinColumn(name = "event_id", nullable = false)
    @ManyToOne
    private Event event;
}
