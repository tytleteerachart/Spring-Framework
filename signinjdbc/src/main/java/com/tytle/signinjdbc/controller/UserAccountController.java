package com.tytle.signinjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tytle.signinjdbc.service.UserAccountService;

@Controller
public class UserAccountController {

    @GetMapping("/user/sign-in")
    public ModelAndView getSignIn() {
        return new UserAccountService().getUserModelAndView();
    }
}