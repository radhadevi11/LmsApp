package com.glosys.lms.dao;

import com.glosys.lms.entity.Payment;

import javax.persistence.EntityManager;

public class PaymentDao extends AbstractDao<Payment> {
    public PaymentDao() {
        super();
    }

    public PaymentDao(EntityManager entityManager) {
        super(entityManager);
    }
}
