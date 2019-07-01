package com.glosys.lms;

import javax.persistence.*;

@Entity
@Table(name = "workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Integer id;

    @Column(name = "training_program_type_id")
    private Integer trainingProgramTypeId;

    @Column(name = "workshop_type_id")
    private Integer workshopTypeId;


    public Workshop() {
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

    public Integer getWorkshopTypeId() {
        return workshopTypeId;
    }

    public void setWorkshopTypeId(Integer workshopTypeId) {
        this.workshopTypeId = workshopTypeId;
    }
}
