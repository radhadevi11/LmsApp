package com.glosys.lms.dao;

import com.glosys.lms.entity.ResearchTrainingType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ResearchTrainingTypeDao extends AbstractDao<ResearchTrainingType> {
    public ResearchTrainingTypeDao() {
        super();
    }

    public ResearchTrainingTypeDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<ResearchTrainingType> getResearchTrainings(){
        try{
            entityManager.getTransaction().begin();
            TypedQuery<ResearchTrainingType> typedQuery = entityManager.createQuery("SELECT rt FROM ResearchTrainingType rt",
                    ResearchTrainingType.class);
            entityManager.getTransaction().commit();

            return typedQuery.getResultList();

        }
        catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get ResearchTrainingType", e);
        }
    }
}
