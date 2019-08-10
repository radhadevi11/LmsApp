package com.glosys.lms.dao;

import com.glosys.lms.entity.WorkshopEnrolment;

import javax.persistence.EntityManager;

public class WorkshopEnrolmentDao extends AbstractDao<WorkshopEnrolment> {
    public WorkshopEnrolmentDao() {super();}

    public WorkshopEnrolmentDao(EntityManager entityManager){
        super(entityManager);
    }


}
