package kg.itacademy.demo.service;


import kg.itacademy.demo.entity.Photo;

public interface PhotoService {
    Photo save(Photo photo);
    Photo findById(Long id);
    Photo deleteById(Long id);
}
