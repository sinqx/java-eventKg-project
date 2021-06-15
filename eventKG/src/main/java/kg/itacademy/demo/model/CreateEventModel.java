package kg.itacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventModel {
    Long mainPhotoId;
    Long eventTypeId;
    Long eventStatusId;
    String title;
    String description;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
