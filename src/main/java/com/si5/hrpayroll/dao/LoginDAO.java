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
    @Qualifier("payrollJdbc")
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public String getPasswordForHR(String username) {
        System.out.println(jdbcTemplate);
        List<Map<String,Object>> list = jdbcTemplate.queryForList(QueryConstants.GET_PASSWORD_FROM_HR.toString(),new Object[]{username,username}) ;
        if(list.size() == 0) {
            return null ;
        }
        Map<String,Object> row = list.get(0) ;
        if(!row.get("JobId").equals("2")) {
            return null ;
        }
        return String.valueOf(row.get("Password")) ;
    }

    public String getPasswordForPayroll(String username) {
    return null ;
    }
}
