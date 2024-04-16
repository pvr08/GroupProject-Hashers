package com.harshitha.imageservice.service;

import com.harshitha.imageservice.entity.Image;
import com.harshitha.imageservice.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final Path rootLocation; // Directory path where images will be stored

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get("images");
    }

    public Image saveImage(String title, MultipartFile file) throws IOException {
        Files.createDirectories(this.rootLocation); // Ensure directory exists.
        Path destinationFile = this.rootLocation.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
        if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
            // This is a security check
            throw new StorageException("Cannot store file outside current directory.");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);
        }

        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setMimeType(file.getContentType());
        image.setFileSize(file.getSize());



        return imageRepository.save(image);
    }

    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }

    // Other methods for update, delete, etc.
}

class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }
}
