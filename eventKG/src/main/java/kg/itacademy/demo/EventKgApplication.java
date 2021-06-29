package kg.itacademy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventKgApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventKgApplication.class, args);
    }

}
