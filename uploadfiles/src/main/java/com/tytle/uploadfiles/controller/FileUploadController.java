package com.tytle.uploadfiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private static String UPLOADED_FOLDER = "D://upload_folder";

    @GetMapping("/uploadfiles")
    public ModelAndView getUploadFiles() {
        return new ModelAndView("/uploadfiles");
    }

    @GetMapping("/uploadStatus")
    public ModelAndView getUploadStatus() {
        return new ModelAndView("/uploadStatus");
    }

    @PostMapping("/uploadfiles")
    public ModelAndView postUploadFiles(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("CONTENT TYPE: " + file.getContentType());
        System.out.println("FILE SIZE: " + file.getSize());
        System.out.println("ORIGINAL_NAME: " + file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("Message", "Empty File");

        try {
            // If file is empty
            if (file.isEmpty() || file.getContentType().equals("application/octet-stream")) {
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
