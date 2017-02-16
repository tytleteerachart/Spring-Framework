package com.tytle.uploadingfiles.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String store(MultipartFile multipartFile);
    Stream<Path> loadAll();
    Resource loadAsResource(String filename);
}