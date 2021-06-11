package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventPhoto;

public interface EventPhotoService {
    EventPhoto save(EventPhoto eventPhoto);
    EventPhoto findById(Long id);
    EventPhoto deleteById(Long id);
}
