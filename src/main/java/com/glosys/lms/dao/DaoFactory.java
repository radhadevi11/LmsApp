package com.glosys.lms.dao;

public class DaoFactory {

    private static SignUpDaoImpl signUpDao = new SignUpDaoImpl();

    public static SignUpDaoImpl getSignUpDao(){
        return signUpDao;
    }
}
