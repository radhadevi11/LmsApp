package com.glosys.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao<T> implements Dao<T> {
    protected EntityManager entityManager;

    public AbstractDao() {
        entityManager = DbConnection.getEntityManager();
    }

    public AbstractDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(T t){

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not save entity",e);
        }

    }




}
