package com.si5.hrpayroll.service;

import com.si5.hrpayroll.dao.LoginDAO;
import com.si5.hrpayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;


@Service
public class LoginService {
    @Autowired
    private LoginDAO loginDAO ;
    public ResponseDTO hrLogin(String username, String password) {
    ResponseDTO responseDTO = new ResponseDTO() ;
    String dbPassword = loginDAO.getPasswordForHR(username) ;
    if(dbPassword.equals("-1")) {
        responseDTO.setStatusId(0);
        responseDTO.setMessage("Access Denied");
        return responseDTO;
    }
    PasswordEncoder pe = new BCryptPasswordEncoder() ;
    return getResponseObject(password,dbPassword) ;
    }

    public ResponseDTO payrollLogin(String username, String password) {
        String dbPassword = loginDAO.getPasswordForPayroll(username) ;
        return getResponseObject(password,dbPassword) ;
    }

    public ResponseDTO getResponseObject(String password, String dbPassword) {
        ResponseDTO responseDTO = new ResponseDTO() ;
        PasswordEncoder pe = new BCryptPasswordEncoder() ;
        if(pe.matches(password,dbPassword)) {
            responseDTO.setStatusId(1);
            responseDTO.setMessage("Logged In!");
        }else{
            responseDTO.setStatusId(0);
            responseDTO.setMessage("Incorrect username or password");
        }
        return responseDTO ;
    }

    public ResponseDTO setPassword(String username, String password) {
        ResponseDTO responseDTO = new ResponseDTO() ;
        PasswordEncoder pe = new BCryptPasswordEncoder() ;
        int result = loginDAO.setPassword(username,pe.encode(password)) ;
        if(result == 0) {
            responseDTO.setStatusId(0);
            responseDTO.setMessage("Failed to update the database");
        }else{
            responseDTO.setStatusId(1);
            responseDTO.setMessage("Password Updated!");
        }
        return responseDTO ;
    }



}
