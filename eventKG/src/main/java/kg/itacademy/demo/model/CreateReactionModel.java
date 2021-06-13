package kg.itacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReactionModel {
    Long userId;
    Long eventId;
    Long photoId;
    String text;
    LocalDateTime publicationDate = LocalDateTime.now();
}
