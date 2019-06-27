package com.glosys.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginDao {
    protected EntityManager entityManager;

    public LoginDao(){
        entityManager = DbConnection.getEntityManager();

    }

    public boolean isValidUser(String mailId, String password) {
        long count = 0;


        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select count(student) from Student student where student.mailId=:mailId" +
                    " and student.password=:password");
            query.setParameter("mailId", mailId);
            query.setParameter("password", password);
            count = (long) query.getSingleResult();
            entityManager.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }


        if(count == 1){
            return true;
        }
        else {
            return false;
        }

    }


}
