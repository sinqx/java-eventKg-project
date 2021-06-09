package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public Photo deleteById(Long id) {
        Photo photo = findById(id);
        if (photo != null) {
            photoRepository.delete(photo);
            return photo;
        }
        return null;// Вернуть исключение
    }
}
