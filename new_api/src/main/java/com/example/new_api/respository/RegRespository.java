package com.example.new_api.respository;

import com.example.new_api.bean.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RegRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public Registration findById(Integer id) {
        String sql = "SELECT * FROM reg WHERE ID = ?";
        try {
            return (Registration) this.jdbcTemplate.queryForObject(sql, new Object[] { id },
                    new BeanPropertyRowMapper<Registration>(Registration.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public void saveUser(Registration registration) {
        String query = "insert into reg(fname,lname,email,pass,confpass)values(?,?,?,?,?)";
        jdbcTemplate.update(query,registration.getFname(),registration.getLname(),registration.getEmail(),registration.getPass(),registration.getConfpass());
    }

    public Registration login(String email, String pass) {
        String sql = "SELECT * FROM reg WHERE email = ? and pass = ?";
        try {
            return (Registration) this.jdbcTemplate.queryForObject(sql, new Object[] { email,pass },
                    new BeanPropertyRowMapper<Registration>(Registration.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
