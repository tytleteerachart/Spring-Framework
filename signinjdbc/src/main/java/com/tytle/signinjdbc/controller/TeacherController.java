package com.tytle.signinjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    @GetMapping("/teacher/home")
    public ModelAndView getHome() {
        return new ModelAndView("/teacher/home");
    }
}