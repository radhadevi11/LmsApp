package com.glosys.lms.dao;

import com.glosys.lms.SignUp;

public class SignUpDaoImpl extends AbstractDao<SignUp> {
    @Override
    protected SignUp createObject(SignUp signUp){
        return new SignUp(signUp.getFirstName(),signUp.getLastName(),signUp.getMailId(),signUp.getCollegeName(),
                signUp.getPassword(),signUp.getRePassword());

    }
}
