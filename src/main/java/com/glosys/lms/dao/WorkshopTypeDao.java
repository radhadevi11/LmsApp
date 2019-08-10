package com.glosys.lms.dao;

import com.glosys.lms.entity.WorkshopType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class WorkshopTypeDao extends AbstractDao<WorkshopType> {

    public WorkshopTypeDao(){
        super();
    }

    public WorkshopTypeDao(EntityManager entityManager){
        super(entityManager);
    }


    public List<WorkshopType> getWorkshopTypes(){
        try{
            entityManager.getTransaction().begin();
            TypedQuery<WorkshopType> query = entityManager.createQuery("SELECT wt FROM WorkshopType wt",
                    WorkshopType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get workshops",e);
        }
    }
}
