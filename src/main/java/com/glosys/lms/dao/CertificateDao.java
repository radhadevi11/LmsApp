package com.glosys.lms.dao;

import com.glosys.lms.entity.Certificate;

import javax.persistence.EntityManager;

public class CertificateDao extends AbstractDao<Certificate> {
    public CertificateDao() {
        super();
    }

    public CertificateDao(EntityManager entityManager) {
        super(entityManager);
    }
}
