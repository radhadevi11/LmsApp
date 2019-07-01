package com.glosys.lms.dao;

import com.glosys.lms.TrainingProgramType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TrainingProgramTypeDao extends AbstractDao<TrainingProgramType> {


    @Override
    protected TrainingProgramType createObject(TrainingProgramType trainingProgramType) {
        return null;
    }

    public List<TrainingProgramType> getTrainingProgramTypes(){

        try{
            entityManager.getTransaction().begin();
            TypedQuery<TrainingProgramType> query = entityManager.createQuery("SELECT t FROM TrainingProgramType t",TrainingProgramType.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get Training program types",e);
        }

    }
}
