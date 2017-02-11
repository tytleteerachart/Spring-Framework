package com.tytle.signinjdbc.repository;

import javax.sql.DataSource;

import com.tytle.signinjdbc.model.UserAccount;
import com.tytle.signinjdbc.rowmapper.UserAccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepository implements UserAccountDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserAccount getUserAccount(String username) {
        try {
            final String SELECT_SQL = "SELECT username, role_id, status FROM user_account WHERE username=?;";
            return this.jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{username}, new UserAccountRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}