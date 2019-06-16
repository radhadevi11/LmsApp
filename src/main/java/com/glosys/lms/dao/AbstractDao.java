package com.glosys.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao<T> implements Dao<T> {
    @Override
    public void save(T t){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.radha.lms");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        t = createObject(t);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

    protected abstract T createObject(T t);

}
