package com.si5.hrpayroll.service;

import com.si5.hrpayroll.dao.LoginDAO;
import com.si5.hrpayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginDAO loginDAO ;
    public ResponseDTO hrLogin(String username, String password) {
    ResponseDTO responseDTO = new ResponseDTO() ;
    responseDTO.setResponse(loginDAO.getPasswordForHR(username)) ;
    return responseDTO ;
    }

    public ResponseDTO payrollLogin(String username, String password) {
    return null ;
    }
}
