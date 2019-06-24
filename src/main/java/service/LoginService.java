package service;

import com.glosys.lms.dao.DaoFactory;

public class LoginService {
    public boolean isValidUser(String mailId, String password){
       return DaoFactory.getLoginDao().isValidUser(mailId, password);
    }
}
