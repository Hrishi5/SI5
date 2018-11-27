package com.si5.hrpayroll;

import com.si5.hrpayroll.dto.FieldsListDTO;
import com.si5.hrpayroll.dto.JsonKeyValueDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import com.si5.hrpayroll.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.si5.hrpayroll.dto.Employee ;


import java.util.List;


@RestController
@RequestMapping("/hr")
public class HRController {
    @Autowired
    public HRService hrservice ;

    @GetMapping("/login")
    public String test() {
        hrservice.login(null) ;
        return "ok";
    }

    @GetMapping("/get-employees")
    public ResponseDTO getEmployeeDetails() {
        return hrservice.getEmployeeDetails() ;
    }

    @PostMapping("/get-employee-details")
    public ResponseDTO getEmployeeDetailedView(@RequestBody JsonKeyValueDTO jkvDTO) {
        return hrservice.getEmployeeDetailedView(jkvDTO.getValue()) ;
    }

    @PatchMapping("/separate-employee")
    public ResponseDTO separateEmployee(@RequestBody JsonKeyValueDTO jkvDTO) {
        return hrservice.separateEmployee(jkvDTO.getValue()) ;
    }

    @PostMapping("/create-employee")
    public ResponseDTO createEmployee(@RequestBody Employee employee) {
        return hrservice.createEmployee(employee) ;
    }

    @RequestMapping("/update-employee")
    public ResponseDTO updateEmployee(@RequestBody FieldsListDTO fieldsListDTO) {
            return hrservice.updateEmployeeDetails(fieldsListDTO.getFieldList(),fieldsListDTO.getEmployeeId()) ;
    }


    
}