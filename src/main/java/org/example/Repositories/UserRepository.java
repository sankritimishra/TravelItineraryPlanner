package org.example.Repositories;

import org.example.DTOs.UserDetailsDTO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public UserDetailsDTO fullUserDetails(Long userId) {
        String sql = "select * from userDetails where userId = :userId;";
        Map<String,Long> mp = new HashMap<>();
        mp.put("userId",userId);
        var userDetails = namedParameterJdbcTemplate.queryForList(sql, mp).get(0);
        return new UserDetailsDTO((Long) userDetails.get("userId"), userDetails.get("username").toString(), userDetails.get("fullName").toString(), userDetails.get("email").toString(), ((Integer) userDetails.get("age")), (Long) userDetails.get("phoneNumber"));

    }

    public void addNewUserDetails(UserDetailsDTO body) {
        String sql;
        sql = "insert into userDetails(userName, fullName, email, age, phoneNumber) values (:userName, :fullName, :email, :age, :phoneNumber);";
        Map<String, Object>mpp = new HashMap<>();
        mpp.put("userName", body.getUserName());
        mpp.put("fullName", body.getFullName());
        mpp.put("email", body.getEmail());
        mpp.put("age", body.getAge());
        mpp.put("phoneNumber", body.getPhoneNumber());

        namedParameterJdbcTemplate.update(sql,mpp);
    }

    public void updateUserDetails(Long userId, UserDetailsDTO body) {
        String sql = "update userDetails set userId = :userId, username = :username, fullName = :fullName, email = :email, age=:age, phoneNumber = :phoneNumber where userId = :userId;";
        Map<String, Object>mp = new HashMap<>();
        mp.put("userId", body.getUserId());
        mp.put("username", body.getUserName());
        mp.put("fullName", body.getFullName());
        mp.put("email", body.getEmail());
        mp.put("age", body.getAge());
        mp.put("phoneNumber", body.getPhoneNumber());

        namedParameterJdbcTemplate.update(sql,mp);
    }

    public void deleteUserDetails(Long userId) {
        String sql = "delete from userDetails where userId = :userId;";
        Map<String,Object> mp = new HashMap<>();
        mp.put("userId", userId);

        namedParameterJdbcTemplate.update(sql,mp);
    }
}
