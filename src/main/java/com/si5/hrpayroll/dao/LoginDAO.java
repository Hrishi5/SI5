package com.si5.hrpayroll.dao;

import com.si5.hrpayroll.Constants.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LoginDAO {
    @Qualifier("passwordJdbc")
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public String getPasswordForHR(String username) {
        List<Map<String,Object>> list = jdbcTemplate.queryForList(QueryConstants.GET_PASSWORD_FROM_HR.toString(),new Object[]{username,username}) ;
        System.out.println(list) ;
        if(list.size() == 0) {
            return null ;
        }
        Map<String,Object> row = list.get(0) ;
        if(!row.get("JobId").equals(2)) {
            return "-1" ;
        }
        return String.valueOf(row.get("Password")) ;
    }

    public String getPasswordForPayroll(String username) {
        List<Map<String,Object>> list = jdbcTemplate.queryForList(QueryConstants.GET_PASSWORD_FROM_HR.toString(),new Object[]{username,username}) ;
        System.out.println(list) ;
        if(list.size() == 0) {
            return null ;
        }
        Map<String,Object> row = list.get(0) ;
        return String.valueOf(row.get("Password")) ;
    }

    public int setPassword(String username, String password) {
        int result = jdbcTemplate.update(QueryConstants.SET_PASSWORD.toString(),new Object[]{password,username,username}) ;
        return result ;
    }
}
