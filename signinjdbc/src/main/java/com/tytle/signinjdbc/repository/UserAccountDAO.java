package com.tytle.signinjdbc.repository;

import com.tytle.signinjdbc.model.UserAccount;

public interface UserAccountDAO {

    UserAccount getUserAccount(String username);
}