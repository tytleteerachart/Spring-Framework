package com.tytle.simplesignin.service;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

public class UserAccountService {

    public ModelAndView getUserModelAndView() {
        // GET USER AUTHORITY (ROLE_ANONYMOUS, ROLE_TEACHER, ROLE_STAFF)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // RETURN MODELANDVIEW ACCORDING TO USER'S ROLE
        for (GrantedAuthority grantedAuthority : authorities) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_TEACHER": {
                    return new ModelAndView("redirect:/teacher/home");
                }
                case "ROLE_STAFF": {
                    return new ModelAndView("redirect:/staff/home");
                }
            }
        }
        return new ModelAndView("/user/sign-in");
    }
}