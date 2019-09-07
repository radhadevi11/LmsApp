package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name="payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Integer id;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "exp_date")
    private LocalDate expDate;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(String cardHolderName, String cardType, String cardNumber, String cvv, LocalDate expDate) {
        this(null, cardHolderName, cardType, cardNumber, cvv, expDate);
    }

    public Payment(Integer id, String cardHolderName, String cardType, String cardNumber, String cvv, LocalDate expDate) {
        this.id = id;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expDate = expDate;
    }

    public Integer getId() {
        return id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getExpDate() {
        return expDate;
    }
}
