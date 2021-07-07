package kg.itacademy.demo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kg.itacademy.demo.entity.Photo;
import kg.itacademy.demo.exception.ObjectNotFoundException;
import kg.itacademy.demo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class PhotoServiceImpl implements PhotoService {
    private static final String CLOUDINARY_URL = "cloudinary://192199225594979:NoQ7SM-G_pmDIpgK6t_wdDABDYE@sinqxcode";

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo save(MultipartFile multipartFile) {
        Photo photo = new Photo();
        File file;
        System.out.println("test2");
        try {
            file = Files.createTempFile(System.currentTimeMillis() + "",
                    multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length() - 4)).toFile();
            multipartFile.transferTo(file);
            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            photo.setCreationaDate(LocalDateTime.now());
            photo.setURL((String) uploadResult.get("url"));
            photo.setName((String) uploadResult.get("public_id"));
            photo.setFormat((String) uploadResult.get("format"));
            System.out.println(photo.getURL());
            return photoRepository.save(photo);
        } catch (Exception e) {
            throw new ObjectNotFoundException("Something went wrong");
        }
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Photo with id \"" + id + "\" doesn't exist"));// Вернуть исключение
    }

    @Override
    public List<Photo> getAllPhotos() {
        try {
            return photoRepository.findAll();
        } catch (NullPointerException ignored) {
            throw new ObjectNotFoundException("List is empty");
        }
    }

    @Override
    public String deleteById(Long id) {
        Photo photo = findById(id);
        if (photo == null) {
            throw new ObjectNotFoundException("Photo with id \"" + id + "\" doesn't exist");
        } else {
            photoRepository.delete(photo);
            return "photo with id \"" + id + "\" is deleted";
        }
    }
}
