package com.tytle.springjdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tytle.springjdbc.service.UserRoleService;

@Controller
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/userrole")
    public ModelAndView getUserRole() {
        return new ModelAndView("/userrole");
    }

    @PostMapping("/userrole")
    public ModelAndView postUserRole(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("userRole", userRoleService.getUserRoleAttribute(httpServletRequest));
        return new ModelAndView("redirect:/userrole");
    }
}