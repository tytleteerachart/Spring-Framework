package com.tytle.springjdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tytle.springjdbc.model.UserRole;

public class UserRoleMapper implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
        UserRole userRole = new UserRole();
        userRole.setRole_id(resultSet.getInt("role_id"));
        userRole.setTh_name(resultSet.getString("th_name"));
        userRole.setEn_name(resultSet.getString("en_name"));
        return userRole;
    }
}