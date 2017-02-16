package com.tytle.uploadfiles.controller;

import com.tytle.uploadfiles.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    // Save the uploaded file to this folder
    // Server path //home//grad//z_upload//
    private static String UPLOADED_FOLDER = "D://upload_folder//";

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/uploadfiles")
    public ModelAndView getUploadFiles() {
        return new ModelAndView("/uploadfiles");
    }

    @GetMapping("/uploadStatus")
    public ModelAndView getUploadStatus() {
        return new ModelAndView("/uploadStatus");
    }

    @GetMapping("/viewfiles/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        Resource resource = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(resource);
    }

    @PostMapping("/uploadfiles")
    public ModelAndView postUploadFiles(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("CONTENT TYPE: " + file.getContentType());
        System.out.println("FILE SIZE: " + file.getSize());
        System.out.println("ORIGINAL_NAME: " + file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("Message", "Empty File");

        try {
            // If file is empty
            if (file.isEmpty() || !file.getContentType().equals("application/pdf")) {
                return new ModelAndView("redirect:/uploadStatus");
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "Success!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ModelAndView("redirect:/uploadStatus");
    }
}
