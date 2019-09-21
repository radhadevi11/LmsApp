package com.glosys.lms.dao;

import com.glosys.lms.entity.CertificateEnrolment;

import javax.persistence.EntityManager;

public class CertificateEnrolmentDao extends AbstractDao<CertificateEnrolment> {
    public CertificateEnrolmentDao() {
        super();
    }

    public CertificateEnrolmentDao(EntityManager entityManager) {
        super(entityManager);
    }
}
