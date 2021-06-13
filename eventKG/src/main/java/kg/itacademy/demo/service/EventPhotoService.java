package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventPhoto;

import java.util.List;

public interface EventPhotoService {
    EventPhoto save(EventPhoto eventPhoto);
    EventPhoto findById(Long id);
    EventPhoto deleteById(Long id);
    List<EventPhoto> getAllEventPhoto(Long id);
}
