package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "corporate_training")
public class CorporateTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporate_training_id")
    private Integer id;


    @Column(name = "corporate_training_type_id")
    private Integer corporateTrainingTypeId;

    public CorporateTraining() {
    }
}

