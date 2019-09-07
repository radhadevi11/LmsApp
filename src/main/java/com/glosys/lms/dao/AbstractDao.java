package com.glosys.lms.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements Dao<T> {
    protected EntityManager entityManager;

    public AbstractDao() {
        entityManager = DbConnection.getEntityManager();
    }

    public AbstractDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public T save(T t){

        try {
            entityManager.getTransaction().begin();
            T mergedEntity = entityManager.merge(t);
            //entityManager.detach(t);
            entityManager.getTransaction().commit();
            return mergedEntity;
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Can not save entity",e);
        }

    }




}
