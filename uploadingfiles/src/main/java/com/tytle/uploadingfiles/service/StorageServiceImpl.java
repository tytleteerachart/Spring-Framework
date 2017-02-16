package com.tytle.uploadingfiles.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;

    @Autowired
    public StorageServiceImpl() {
        this.rootLocation = Paths.get("D://upload_folder//");
    }

    @Override
    public String store(MultipartFile multipartFile) {
        try {
            if (multipartFile.isEmpty() || !multipartFile.getContentType().equals("application/pdf")) {
                return "Empty file or content type not supported";
            }
            Files.write(this.rootLocation.resolve(multipartFile.getOriginalFilename()), multipartFile.getBytes());
        } catch (IOException ex) {
            return "Failed to store file";
        }
        return "You successfully uploaded " + multipartFile.getOriginalFilename();
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path path = rootLocation.resolve(filename);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
