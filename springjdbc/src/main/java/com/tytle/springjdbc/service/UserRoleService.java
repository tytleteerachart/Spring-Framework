package com.tytle.springjdbc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tytle.springjdbc.model.UserRole;
import com.tytle.springjdbc.repository.UserRoleRepository;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    // Get UserRole Attribute for redirect
    public UserRole getUserRoleAttribute(HttpServletRequest httpServletRequest) {
        try {
            int role_id = Integer.parseInt(httpServletRequest.getParameter("role_id"));
            return userRoleRepository.getUserRole(role_id);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}