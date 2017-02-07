package it.kmitl.securitysignin.repository;

import it.kmitl.securitysignin.model.UserAccount;

public interface UserAccountDAO {

    public UserAccount getUserAccount(String username);
}
