package com.si5.hrpayroll.dao;

import com.si5.hrpayroll.Constants.QueryConstants;
import com.si5.hrpayroll.dto.BankDetailsDTO;
import com.si5.hrpayroll.dto.PayrollDTO;
import com.si5.hrpayroll.dto.PayrollDetailsDTO;
import com.si5.hrpayroll.dto.TaxDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayrollDAO {
    @Qualifier("payrollJdbc")
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public PayrollDTO getEmployeeDetails(String employeeId) {
        PayrollDTO payrollDTO = new PayrollDTO() ;
        PayrollDetailsDTO payrollDetailsDTO = jdbcTemplate.queryForObject(QueryConstants.GET_PAYROLL_DETAILS.toString(),
                new Object[]{employeeId}, new BeanPropertyRowMapper<PayrollDetailsDTO>(PayrollDetailsDTO.class)) ;

        BankDetailsDTO bankDetailsDTO = jdbcTemplate.queryForObject(QueryConstants.GET_BANK_DETAILS.toString(),
                new Object[]{employeeId}, new BeanPropertyRowMapper<BankDetailsDTO>(BankDetailsDTO.class)) ;

        TaxDetailsDTO taxDetailsDTO = jdbcTemplate.queryForObject(QueryConstants.GET_TAX_DETAILS.toString(),
                new Object[]{employeeId},new BeanPropertyRowMapper<TaxDetailsDTO>(TaxDetailsDTO.class)) ;
        return new PayrollDTO(payrollDetailsDTO,bankDetailsDTO,taxDetailsDTO) ;
    }

    public int updateEmployeeDetails(PayrollDTO payrollDTO) {
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate) ;
        String employeeId = payrollDTO.getPayrollDetails().getEmployeeId() ;
        payrollDTO.getTaxDetails().setEmployeeId(employeeId);
        int result = npjt.update(QueryConstants.UPDATE_PAYROLL_DETAILS.toString(), new BeanPropertySqlParameterSource(payrollDTO.getPayrollDetails())) ;
        result+= npjt.update(QueryConstants.UPDATE_TAX_DETAILS.toString(), new BeanPropertySqlParameterSource(payrollDTO.getTaxDetails())) ;
        return result ;
    }


}
