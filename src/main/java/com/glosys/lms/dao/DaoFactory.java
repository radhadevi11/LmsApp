package com.glosys.lms.dao;

public class DaoFactory {

    private static SignUpDaoImpl signUpDao = new SignUpDaoImpl();
    private static LoginDao loginDao = new LoginDao();

    public static SignUpDaoImpl getSignUpDao(){
        return signUpDao;
    }

    public static LoginDao getLoginDao(){return loginDao;}
}
