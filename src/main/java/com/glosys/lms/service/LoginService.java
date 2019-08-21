package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Student;

public class LoginService {
    public Student getValidUser(String mailId, String password){
       return DaoFactory.getLoginDao().getValidUser(mailId, password);
    }
}
