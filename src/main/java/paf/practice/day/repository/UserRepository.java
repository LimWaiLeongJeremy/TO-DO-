package paf.practice.day.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.practice.day.model.User;

import static paf.practice.day.repository.Query.*;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertUser(User user) {
        return jdbcTemplate.update(
            SQL_INSERT_USER, 
            user.getUsername(), 
            user.getPassword(), 
            user.getEmail(), 
            user.getDate(), 
            user.getPhone());
    }
    
    public SqlRowSet authenticate(User user) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(
                            SQL_AUTHENTICATE_USER, 
                            user.getUsername(), 
                            user.getPassword());

        return rs;
    }
}
