package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTrainingType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ResearchTrainingDao extends AbstractDao<ResearchTrainingType> {

    public ResearchTrainingDao() {
        super();
    }

    public ResearchTrainingDao(EntityManager entityManager){
        super(entityManager);
    }

    public List<ResearchTrainingType> getResearchTrainings(){
        try{
            entityManager.getTransaction().begin();
            TypedQuery<ResearchTrainingType> typedQuery = entityManager.createQuery("SELECT rt FROM ResearchTraining rt",
                    ResearchTrainingType.class);
            entityManager.getTransaction().commit();
            List<ResearchTrainingType> resultList = typedQuery.getResultList();
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
