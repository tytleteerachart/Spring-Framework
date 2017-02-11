package com.tytle.signinjdbc.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.tytle.signinjdbc.model.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountRowMapper implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(resultSet.getString("username"));
        userAccount.setRole_id(resultSet.getInt("role_id"));
        userAccount.setStatus(resultSet.getString("status"));
        return userAccount;
    }
}