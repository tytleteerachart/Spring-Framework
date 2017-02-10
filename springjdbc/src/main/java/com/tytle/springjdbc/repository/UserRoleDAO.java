package com.tytle.springjdbc.repository;

import com.tytle.springjdbc.model.UserRole;

public interface UserRoleDAO {

    public UserRole getUserRole(int role_id);
}