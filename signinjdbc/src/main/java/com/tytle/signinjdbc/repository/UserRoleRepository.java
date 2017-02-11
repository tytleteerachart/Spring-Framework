package com.tytle.signinjdbc.repository;

import javax.sql.DataSource;

import com.tytle.signinjdbc.model.UserRole;
import com.tytle.signinjdbc.rowmapper.UserRoleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository implements UserRoleDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserRole getUserRole(int role_id) {
        try {
            final String SELECT_SQL = "SELECT role_id, th_name, en_name FROM user_role WHERE role_id=?;";
            return this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{role_id}, new UserRoleRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}