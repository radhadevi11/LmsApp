package com.glosys.lms;

import javax.persistence.*;

@Entity
@Table(name = "training_program_type")

public class TrainingProgramType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_program_type_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public TrainingProgramType() {
    }

    public TrainingProgramType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
