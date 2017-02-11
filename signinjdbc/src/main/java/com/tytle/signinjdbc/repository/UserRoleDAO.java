package com.tytle.signinjdbc.repository;

import com.tytle.signinjdbc.model.UserRole;

public interface UserRoleDAO {

    UserRole getUserRole(int role_id);
}