package com.glosys.lms.dao;

import com.glosys.lms.InplantTrainingType;

import javax.persistence.TypedQuery;
import java.util.List;

public class InplantTrainingTypeDao extends AbstractDao<InplantTrainingType> {



    public List<InplantTrainingType> getInplantTrainingTypes(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<InplantTrainingType> query = entityManager.createQuery("SELECT i FROM InplantTrainingType i",
                    InplantTrainingType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get InplantTrainingType",e);
        }
    }
}
