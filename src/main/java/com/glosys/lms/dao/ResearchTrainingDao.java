package com.glosys.lms.dao;

import com.glosys.lms.ResearchTraining;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ResearchTrainingDao extends AbstractDao<ResearchTraining> {

    public ResearchTrainingDao() {
        super();
    }

    public ResearchTrainingDao(EntityManager entityManager){
        super(entityManager);
    }

    public List<ResearchTraining> getResearchTrainings(){
        try{
            entityManager.getTransaction().begin();
            TypedQuery<ResearchTraining> typedQuery = entityManager.createQuery("SELECT rt FROM ResearchTraining rt",ResearchTraining.class);
            entityManager.getTransaction().commit();
            return typedQuery.getResultList();
        }
        catch (Exception e){

            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get ResearchTrainings", e);
        }
    }

}
