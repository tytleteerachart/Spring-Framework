package it.kmitl.securitysignin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/user/sign-in")
    public ModelAndView getSignIn() {
        return new ModelAndView("/user/sign-in");
    }

    @GetMapping("/teacher/home")
    public ModelAndView getTeacherHome() {
        return new ModelAndView("/teacher/home");
    }

    @GetMapping("/staff/home")
    public ModelAndView getStaffHome() {
        return new ModelAndView("/staff/home");
    }
}