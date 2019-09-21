package com.glosys.lms.dao;

import com.glosys.lms.entity.InplantTrainingEnrolment;

import javax.persistence.EntityManager;

public class InplantTrainingEnrolmentDao extends AbstractDao<InplantTrainingEnrolment> {
    public InplantTrainingEnrolmentDao() {
        super();
    }

    public InplantTrainingEnrolmentDao(EntityManager entityManager) {
        super(entityManager);
    }
}
