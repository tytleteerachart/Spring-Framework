package com.tytle.uploadingfiles.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tytle.uploadingfiles.service.StorageService;

@Controller
public class UploadingFilesController {

    private final StorageService storageService;

    @Autowired
    public UploadingFilesController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/home")
    public ModelAndView getHome(Model model) throws IOException {
        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(UploadingFilesController.class, "viewFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        model.addAttribute("filenames", storageService
                .loadAll()
                .map(Path::getFileName).collect(Collectors.toList()));
        return new ModelAndView("/home");
    }

    @PostMapping("/home")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", storageService.store(multipartFile));
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        Resource resource = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(resource);
    }
}