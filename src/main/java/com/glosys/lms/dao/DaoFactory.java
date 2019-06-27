package com.glosys.lms.dao;

public class DaoFactory {

    private static StudentDaoImpl studentDao = new StudentDaoImpl();
    private static LoginDao loginDao = new LoginDao();

    public static StudentDaoImpl getStudentDao(){
        return studentDao;
    }

    public static LoginDao getLoginDao(){return loginDao;}
}
