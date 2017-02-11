package com.tytle.signinjdbc.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tytle.signinjdbc.model.UserAccount;
import com.tytle.signinjdbc.model.UserRole;
import com.tytle.signinjdbc.repository.UserAccountRepository;
import com.tytle.signinjdbc.repository.UserRoleRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserRoleRepository userRoleRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public AuthenticationService(UserRoleRepository userRoleRepository, UserAccountRepository userAccountRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Get UserAccount by username
        UserAccount userAccount = userAccountRepository.getUserAccount(username);

        // ACTIVE USER
        if (userAccount.getStatus().equals("active")) {
            UserRole userRole = userRoleRepository.getUserRole(userAccount.getRole_id());
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getEn_name());
            return new User(userAccount.getUsername(), "LDAP", Arrays.asList(grantedAuthority));
        }
        // INACTIVE USER
        return new User(userAccount.getUsername(), "LDAP", Arrays.asList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
    }
}