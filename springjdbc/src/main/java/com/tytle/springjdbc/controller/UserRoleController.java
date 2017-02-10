package com.tytle.springjdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tytle.springjdbc.repository.UserRoleRepository;

@Controller
public class UserRoleController {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/userrole")
    public ModelAndView getUserRole() {
        return new ModelAndView("/userrole");
    }

    @PostMapping("/userrole")
    public ModelAndView postUserRole(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        try {
            int role_id = Integer.parseInt(httpServletRequest.getParameter("role_id"));
            redirectAttributes.addFlashAttribute("userRole", userRoleRepository.getUserRole(role_id));
            System.out.println(userRoleRepository.getUserRole(role_id));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return new ModelAndView("redirect:/userrole");
    }
}