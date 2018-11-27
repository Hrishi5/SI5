package com.si5.hrpayroll.dao;

import com.si5.hrpayroll.Constants.QueryConstants;
import com.si5.hrpayroll.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HrDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate  ;

    @Autowired
    public HrDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate ;
    }




    public void testDatabaseConnection() {
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from EducationDetails") ;
        if(list.size() > 0) {
            System.out.println("test success") ;
            System.out.println(list) ;
        }else{
            System.out.print("test failed");
        }
    }

    public List<Employee> getEmployeeDetails() {
        List<Employee> employeeDetails = jdbcTemplate.query(QueryConstants.GET_EMPLOYEES.toString(),new BeanPropertyRowMapper<Employee>(Employee.class)) ;
        System.out.print(employeeDetails);
        return employeeDetails ;
    }

    public List<Employee> getEmployeeDetailView(String employeeId) {
        List<Employee> resultList = jdbcTemplate.query(QueryConstants.GET_EMPLOYEE_DETAILS.toString(), new Object[]{employeeId}, new RowMapper<Employee>(){
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                ContactDetails contactDetails = (new BeanPropertyRowMapper<ContactDetails>(ContactDetails.class)).mapRow(rs, rowNum);
                EducationDetails educationDetails = (new BeanPropertyRowMapper<EducationDetails>(EducationDetails.class)).mapRow(rs, rowNum);
                SalaryDetails salaryDetails = (new BeanPropertyRowMapper<SalaryDetails>(SalaryDetails.class)).mapRow(rs, rowNum);
                Employee employee = (new BeanPropertyRowMapper<Employee>(Employee.class)).mapRow(rs, rowNum);
                employee.setContactDetails(contactDetails);
                employee.setEducationDetails(educationDetails);
                employee.setSalaryDetails(salaryDetails);
                return employee;
            }
        }) ;

        return resultList ;
    }

    public int initiateEmployeeSeperation(String employeeId) {
       int result = jdbcTemplate.update(QueryConstants.DEACTIVATE_EMPLOYEE.toString(), new Object[]{employeeId}) ;
        return result ;
    }

    public int createEmployee(Employee employee) {
        int result = 0 ;
        employee.setIsActive(true);
        employee.setIsMigrated(false);
        SqlParameterSource ps= new BeanPropertySqlParameterSource(employee) ;
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("EmployeeDetails").usingGeneratedKeyColumns("EmployeeId") ;
        Number key = jdbcInsert.executeAndReturnKey(ps) ;
        if(key != null) {
            result++ ;
        }
        String employeeId = String.valueOf(key.intValue()) ;
        employee.setEmployeeId(employeeId);
        employee.getContactDetails().setEmployeeId(employeeId);
        //employee.getContactDetails().setContactId(getMaxId(QueryConstants.GET_MAX_ID_CONTACTDETAILS.toString())) ;
        employee.getEducationDetails().setEmployeeId(employeeId);
        //employee.getEducationDetails().setEducationId(getMaxId(QueryConstants.GET_MAX_ID_EDUCATIONDETAILS.toString()));
        //employee.getSalaryDetails().setSalaryId(getMaxId(QueryConstants.GET_MAX_ID_SALARYDETAILS.toString()));
        employee.getSalaryDetails().setEmployeeId(employeeId);
        SqlParameterSource cdps = new BeanPropertySqlParameterSource(employee.getContactDetails()) ;
        SqlParameterSource sdps = new BeanPropertySqlParameterSource(employee.getSalaryDetails()) ;
        SqlParameterSource edps = new BeanPropertySqlParameterSource(employee.getEducationDetails()) ;

        jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("ContactDetails") ;
        result += jdbcInsert.execute(cdps) ;
        jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("SalaryDetails") ;
        result += jdbcInsert.execute(sdps) ;
        jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("EducationDetails") ;
        result += jdbcInsert.execute(edps) ;
        return key.intValue() ;
    }

    public String getMaxId(String query) {
        int result = jdbcTemplate.queryForObject(query,Integer.class);
        return String.valueOf(result + 1) ;
    }

    public int updateEmployeeDetails(List<JsonKeyValueDTO> updateList,String table,String employeeId) {
        StringBuilder query = new StringBuilder("Update " + table + " set ") ;
        for(JsonKeyValueDTO prop : updateList) {
            if(prop.getKey() != null && prop.getValue() != null) {
                query.append(prop.getKey() + "=" + prop.getValue() + ",");
            }
        }
        query.deleteCharAt(query.length()-1) ;
        query.append(" where employeeId = ?") ;
        return jdbcTemplate.update(query.toString() , new Object[]{employeeId}) ;
    }

}
