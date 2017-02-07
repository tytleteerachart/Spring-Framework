package it.kmitl.securitysignin.repository;

import it.kmitl.securitysignin.model.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDAOImpl implements UserAccountDAO {

    @Override
    public UserAccount getUserAccount(String username) {
        return null;
    }
}
