package kg.itacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class registrationModel {
    String login;
    String password;
    String email;
    String gender;
}
