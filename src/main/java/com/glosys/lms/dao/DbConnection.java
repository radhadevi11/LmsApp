package com.glosys.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.radha.lms");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
