package com.si5.hrpayroll.service;

import com.si5.hrpayroll.dao.PayrollDAO;
import com.si5.hrpayroll.dto.PayrollDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class PayrollService {

    @Autowired
    private PayrollDAO payrollDAO ;

    public ResponseDTO getEmployeeDetails(String employeeId) {
        PayrollDTO payrollDTO = payrollDAO.getEmployeeDetails(employeeId) ;
        ResponseDTO responseDTO = new ResponseDTO() ;
        if(payrollDTO == null || payrollDTO.getPayrollDetails() == null) {
            responseDTO.setMessage("Employee details not found!");
        }else{
            responseDTO.setStatusId(1);
            responseDTO.setMessage("Employee details retrieved successfully!");
            responseDTO.setResponse(payrollDTO);
        }
        return responseDTO ;
    }

}
