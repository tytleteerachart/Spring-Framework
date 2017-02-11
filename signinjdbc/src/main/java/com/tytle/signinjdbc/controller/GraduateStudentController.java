package com.tytle.signinjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GraduateStudentController {

    @GetMapping("/graduate-student/home")
    public ModelAndView getHome() {
        return new ModelAndView("/graduate-student/home");
    }
}