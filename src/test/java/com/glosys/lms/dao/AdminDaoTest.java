package com.glosys.lms.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminDaoTest {
   @Test
   public void testIsValidAdmin(){
        AdminDao adminDao = new AdminDao();
        boolean actual = adminDao.isValidAdmin("Radha33", "radha");
        assertEquals(true,actual);
    }

    @Test
    public void testNotValidAdmin(){
        AdminDao adminDao = new AdminDao();
        boolean actual = adminDao.isValidAdmin("somename", "some password");
        assertEquals(false,actual);
    }

}