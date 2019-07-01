package com.glosys.lms.dao;

import com.glosys.lms.WorkshopType;

import javax.persistence.TypedQuery;
import java.util.List;

public class WorkshopTypeDao extends AbstractDao<WorkshopType> {

    @Override
    protected WorkshopType createObject(WorkshopType workshopType) {
        return null;
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
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get workshops",e);
        }
    }
}
