package com.glosys.lms.dao;

import com.glosys.lms.entity.TrainingProgramType;

import javax.persistence.TypedQuery;
import java.util.List;

public class TrainingProgramTypeDao extends AbstractDao<TrainingProgramType> {




    public List<TrainingProgramType> getTrainingProgramTypes(){

        try{
            entityManager.getTransaction().begin();
            TypedQuery<TrainingProgramType> query = entityManager.createQuery("SELECT t FROM TrainingProgramType t",TrainingProgramType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get Training program types",e);
        }

    }
}
