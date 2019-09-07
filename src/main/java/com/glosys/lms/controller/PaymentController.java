package com.glosys.lms.controller;

import com.glosys.lms.entity.Payment;
import com.glosys.lms.service.PaymentService;

public class PaymentController {
    private static PaymentService paymentService = new PaymentService();

    public void savePayment(Payment payment){
        paymentService.savePayment(payment);
    }
}
