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



}
