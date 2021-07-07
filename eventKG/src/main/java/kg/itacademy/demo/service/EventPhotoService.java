package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventPhoto;
import kg.itacademy.demo.model.CreateEventPhotoModel;

import java.util.List;

public interface EventPhotoService {
    EventPhoto save(EventPhoto eventPhoto);
    EventPhoto save(CreateEventPhotoModel eventPhotoModel);
    EventPhoto findById(Long id);
    EventPhoto deleteAllByEventId(Long id);
    List<EventPhoto> getAllEventPhoto(Long id);
}
