package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "inplant_training")
public class InplantTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inplant_training_id")
    private Integer id;

    @Column(name = "training_program_type_id")
    private Integer trainingProgramTypeId;

    @Column(name = "inplant_training_type_id")
    private Integer inplantTrainingTypeId;

    public InplantTraining() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainingProgramTypeId() {
        return trainingProgramTypeId;
    }

    public void setTrainingProgramTypeId(Integer trainingProgramTypeId) {
        this.trainingProgramTypeId = trainingProgramTypeId;
    }

    public Integer getInplantTrainingTypeId() {
        return inplantTrainingTypeId;
    }

    public void setInplantTrainingTypeId(Integer inplantTrainingTypeId) {
        this.inplantTrainingTypeId = inplantTrainingTypeId;
    }


}
