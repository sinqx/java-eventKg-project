package kg.itacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReactionModel {
    Long eventId;
    Long photoId;
    String text;
}
