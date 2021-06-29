package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    Photo save(MultipartFile multipartFile);
    Photo findById(Long id);
    Photo deleteById(Long id);
}
