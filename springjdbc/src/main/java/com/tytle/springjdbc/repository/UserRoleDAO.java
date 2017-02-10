package com.tytle.springjdbc.repository;

import com.tytle.springjdbc.model.UserRole;

public interface UserRoleDAO {

    UserRole getUserRole(int role_id);
}