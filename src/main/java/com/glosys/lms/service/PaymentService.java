package com.glosys.lms.service;

import com.glosys.lms.dao.DaoFactory;
import com.glosys.lms.entity.Payment;

public class PaymentService {
    public void savePayment(Payment payment){
        DaoFactory.getPaymentDao().save(payment);
    }
}
