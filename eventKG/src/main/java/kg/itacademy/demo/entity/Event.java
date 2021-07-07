package kg.itacademy.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creatorUser;

    @OneToOne
    @JoinColumn(name = "main_photo_id")
    private Photo mainPhoto;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "views", nullable = false)
    private Long views;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "event_type", nullable = false)
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "event_status", nullable = false)
    private EventStatus eventStatus;
}

