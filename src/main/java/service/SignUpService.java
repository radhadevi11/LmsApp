package service;

import com.glosys.lms.SignUp;
import com.glosys.lms.dao.DaoFactory;

public class SignUpService {
    public void saveSignUp(SignUp signUp){
        DaoFactory.getSignUpDao().save(signUp);
    }

}
