package com.glosys.lms.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginDaoTest {

    @Test
    public void testIsvalidUser(){
        LoginDao loginDao = new LoginDao();
        boolean actual = loginDao.isValidUser("shalu@gmail.com","123");
        System.out.println("Result:"+actual);
        assertEquals(true,actual);


    }

    @Test
    public void testInvalidUser(){
        LoginDao loginDao = new LoginDao();
        boolean actual = loginDao.isValidUser("aaaaa@gmail.com","111");
        System.out.println("Result:"+actual);
        assertEquals(false,actual);
    }


}