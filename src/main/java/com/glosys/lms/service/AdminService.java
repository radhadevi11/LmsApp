package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;

public class AdminService {
    public boolean isValidAdmin(String name, String password){
        return DaoFactory.getAdminDao().isValidAdmin(name, password);
    }
}
