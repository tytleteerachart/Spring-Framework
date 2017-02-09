package com.tytle.simplesignin.controller;

import com.tytle.simplesignin.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/user/sign-in")
    public ModelAndView getSignIn() {
        return new UserAccountService().getUserModelAndView();
    }
}