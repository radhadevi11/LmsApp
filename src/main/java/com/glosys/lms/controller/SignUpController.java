package com.glosys.lms.controller;

import com.glosys.lms.SignUp;
import service.SignUpService;

public class SignUpController {
    private static SignUpService signUpService = new SignUpService();

    public void saveSignUp(SignUp signUp){
        signUpService.saveSignUp(signUp);
    }
}
