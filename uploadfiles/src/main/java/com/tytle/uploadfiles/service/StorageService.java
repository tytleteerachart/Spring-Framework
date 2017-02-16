package com.tytle.uploadfiles.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    public Resource loadAsResource(String filename) {
        try {
            Path path = Paths.get("D://upload_folder//" + filename);
            System.out.println(path.toUri());
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                System.out.println("TEST");
                return resource;
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        System.out.println("zTEST");
        return null;
    }
}