package com.glosys.lms.dao;

import com.glosys.lms.CorporateTrainingType;
import com.glosys.lms.InplantTrainingType;

import javax.persistence.TypedQuery;
import java.util.List;

public class CorporateTrainingTypeDao extends AbstractDao<CorporateTrainingType> {


    public List<CorporateTrainingType> getCorporateTrainingTypes(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<CorporateTrainingType> query = entityManager.createQuery("SELECT ct FROM CorporateTrainingType ct",
                    CorporateTrainingType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get CorporateTrainingType",e);
        }
    }
}
