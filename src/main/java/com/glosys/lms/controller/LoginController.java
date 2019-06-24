package com.glosys.lms.controller;

import service.LoginService;

public class LoginController {

    private static LoginService loginService = new LoginService();

    public boolean isValidUser(String mailId, String password){
        return loginService.isValidUser(mailId, password);
    }
}
