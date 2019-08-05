package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTraining;

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
            TypedQuery<ResearchTraining> typedQuery = entityManager.createQuery("SELECT rt FROM ResearchTraining rt",
                    ResearchTraining.class);
            entityManager.getTransaction().commit();
            List<ResearchTraining> resultList = typedQuery.getResultList();
            System.out.println("size of Research training "+resultList.size());
            return resultList;

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get ResearchTrainings", e);
        }
    }

}
