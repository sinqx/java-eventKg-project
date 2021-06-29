package kg.itacademy.demo.scheduler;

import kg.itacademy.demo.entity.Event;
import kg.itacademy.demo.service.EventService;
import kg.itacademy.demo.service.EventStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class Scheduler {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventStatusService eventStatusService;

    // @Scheduled(cron = "0 0 12 * * *")
    @Scheduled(cron = "*/5 * * * * *")
    public void eventStatusChange() {
        List<Event> events = eventService.getAllEvents();
        LocalDate today = LocalDate.now();
        LocalDateTime startDayWithTime;
        LocalDate startDay;
        for (Event event : events) {
            startDayWithTime = event.getStartDate();
            startDay = LocalDate.from(startDayWithTime);
            if (startDay.isBefore(today)) {
                changeStatus((long) 1, event);
//                System.out.println("ещё не прошло");
            } else if (startDay.equals(today)) {
                changeStatus((long) 2, event);
//                System.out.println("в процессе");
            } else {
                changeStatus((long) 3, event);
//                System.out.println("уже прошло");
            }
        }
    }

    public void changeStatus(Long status, Event event) {
        event.setEventStatus(eventStatusService.findById(status));
        eventService.save(event);
    }
}


