package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTrainingType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class InplantTrainingTypeDao extends AbstractDao<InplantTrainingType> {
    public InplantTrainingTypeDao() {
        super();
    }

    public InplantTrainingTypeDao(EntityManager entityManager) {
        super(entityManager);
    }


    public List<InplantTrainingType> getInplantTrainingTypes(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<InplantTrainingType> query = entityManager.createQuery("SELECT i FROM InplantTrainingType i",
                    InplantTrainingType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get InplantTrainingType",e);
        }
    }
}
