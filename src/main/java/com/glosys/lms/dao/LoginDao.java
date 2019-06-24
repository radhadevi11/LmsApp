package com.glosys.lms.dao;

import com.glosys.lms.SignUp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;

public class LoginDao {
    public boolean isValidUser(String mailId, String password) {
        long count = 0;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.radha.lms");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select count(signup) from SignUp signup where signup.mailId=:mailId" +
                    " and signup.password=:password");
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
