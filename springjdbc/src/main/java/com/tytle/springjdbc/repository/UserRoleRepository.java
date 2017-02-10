package com.tytle.springjdbc.repository;

import com.tytle.springjdbc.model.UserRole;
import com.tytle.springjdbc.rowmapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
public class UserRoleRepository implements UserRoleDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional(readOnly = true)
    public UserRole getUserRole(int role_id) {
        try {
            final String SELECT_SQL = "SELECT role_id, th_name, en_name FROM user_role WHERE role_id = ?;";
            return this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{role_id}, new UserRoleMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}