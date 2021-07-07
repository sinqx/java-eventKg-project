package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
    Photo save(MultipartFile multipartFile);
    Photo findById(Long id);
    List<Photo> getAllPhotos();
    String deleteById(Long id);
}
