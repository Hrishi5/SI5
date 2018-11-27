package com.si5.hrpayroll;

import com.si5.hrpayroll.dto.JsonKeyValueDTO;
import com.si5.hrpayroll.dto.ResponseDTO;
import com.si5.hrpayroll.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService ;

    @RequestMapping("/hr-login")
    public ResponseDTO hrLogin(@RequestBody JsonKeyValueDTO loginDetails) {
        return  loginService.hrLogin(loginDetails.getKey(),loginDetails.getValue());
    }

    @RequestMapping("/payroll-login")
    public ResponseDTO payrollLogin(@RequestBody JsonKeyValueDTO loginDetails) {
        return null ;
    }

}
