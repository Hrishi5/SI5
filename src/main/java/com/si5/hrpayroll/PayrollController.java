package com.si5.hrpayroll;

import com.si5.hrpayroll.dto.JsonKeyValueDTO;
import com.si5.hrpayroll.dto.PayrollDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import com.si5.hrpayroll.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService ;

    @GetMapping("/get-employee-details")
    public ResponseDTO getEmployeeDetails(@RequestParam("employeeId") String employeeId) {
        return payrollService.getEmployeeDetails(employeeId) ;
    }

    @PatchMapping("update-payroll-details")
    public ResponseDTO updateDetails(@RequestBody PayrollDTO payrollDTO) {

        return payrollService.updateEmployeeDetails(payrollDTO) ;
    }
}
