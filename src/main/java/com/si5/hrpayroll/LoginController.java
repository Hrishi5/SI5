package com.si5.hrpayroll;

import com.si5.hrpayroll.dto.JsonKeyValueDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import com.si5.hrpayroll.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService ;

    @PostMapping("/hr-login")
    public ResponseDTO hrLogin(@RequestBody JsonKeyValueDTO loginDetails) {
        return  loginService.hrLogin(loginDetails.getKey(),loginDetails.getValue());
    }

    @PostMapping("/payroll-login")
    public ResponseDTO payrollLogin(@RequestBody JsonKeyValueDTO loginDetails) {
        return loginService.payrollLogin(loginDetails.getKey(),loginDetails.getValue()) ;
    }

    @PatchMapping("/set-password")
    public ResponseDTO setPassword(@RequestBody JsonKeyValueDTO loginDetails) {
        return loginService.setPassword(loginDetails.getKey(),loginDetails.getValue()) ;
    }

}
