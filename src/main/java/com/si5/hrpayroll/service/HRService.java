package com.si5.hrpayroll.service;

import com.si5.hrpayroll.dao.HrDAO;
import com.si5.hrpayroll.dto.JsonKeyValueDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import com.si5.hrpayroll.dto.Employee ;

@Service
public class HRService {
    @Autowired
    public HrDAO hrdao ;
    public ResponseDTO login(Employee user) {
        hrdao.testDatabaseConnection();
        return null ;
    }

    public ResponseDTO getEmployeeDetails() {
        List<Employee> employeeList = hrdao.getEmployeeDetails() ;
        ResponseDTO responseDTO = new ResponseDTO() ;
        if(employeeList.size() < 0) {
            responseDTO.setStatusId(0);
            responseDTO.setMessage("No employees found");
        }else{
            responseDTO.setStatusId(1);
            responseDTO.setMessage("Employees fetched successfully");
            responseDTO.setResponse(employeeList);
        }
        return responseDTO ;
    }

    public ResponseDTO getEmployeeDetailedView(String employeeId) {
        List<Employee> employeeList = hrdao.getEmployeeDetailView(employeeId) ;
        String success = "Employees fetched successfully" ;
        String failure = "No employees found" ;
        return getResponseObjectForIntResult(employeeList.size(),success,failure,employeeList) ;
    }

    public ResponseDTO separateEmployee(String employeeId) {

        int result = hrdao.initiateEmployeeSeperation(employeeId) ;
        String success = "Employee separation successful" ;
        String failure = "Employee not found or already separated" ;
        return getResponseObjectForIntResult(result,success,failure,null) ;
    }

    public ResponseDTO createEmployee(Employee employee) {

        int result = hrdao.createEmployee(employee) ;
        return getResponseObjectForIntResult(result,"Employee created successfully","Employee creation failed",null) ;
    }

    public ResponseDTO updateEmployeeDetails(Employee employee) {
        int result = hrdao.updateEmployeeDetails(employee) ;
        String successMsg = "Employee " + employee.getEmployeeId() + " updated successfully!" ;
        String failureMsg = "Failed to update Employee " + employee.getEmployeeId() ;
        return getResponseObjectForIntResult(result,successMsg, failureMsg, null) ;
    }

    public ResponseDTO getResponseObjectForIntResult(int result, String success, String failure,List response) {
        ResponseDTO responseDTO = new ResponseDTO() ;
        if(result > 0) {
            responseDTO.setStatusId(1);
            responseDTO.setMessage(success);
            if(response != null) {
                responseDTO.setResponse(response);
            }else {
                responseDTO.setResponse(result);
            }
        }else{
            responseDTO.setStatusId(0);
            responseDTO.setMessage(failure);
        }
        return responseDTO ;
    }


}