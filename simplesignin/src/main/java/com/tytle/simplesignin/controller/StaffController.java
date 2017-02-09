package com.tytle.simplesignin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {

    @GetMapping("/staff/home")
    public ModelAndView getHome() {
        return new ModelAndView("/staff/home");
    }
}