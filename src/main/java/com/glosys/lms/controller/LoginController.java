package com.glosys.lms.controller;

import com.glosys.lms.entity.Student;
import com.glosys.lms.service.LoginService;

public class LoginController {

    private static LoginService loginService = new LoginService();

    public Student getValidUser(String mailId, String password){
        return loginService.getValidUser(mailId, password);
    }
}
