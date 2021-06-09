package kg.itacademy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import kg.itacademy.demo.entity.User;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event eventId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "publication_date", nullable = false)
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photoId;
}
