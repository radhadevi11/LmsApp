package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "corporate_training")
public class CorporateTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporate_training_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "corporate_training_type_id")
    private CorporateTrainingType corporateTrainingType;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "start_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    @Column(name = "material_path")
    private String materialPath;


    public CorporateTraining() {
    }

    public CorporateTraining(CorporateTrainingType corporateTrainingType, Course course, LocalDate date, Trainer trainer, String materialPath) {
        this(null, corporateTrainingType, course, date, trainer, materialPath);
    }

    public CorporateTraining(Integer id, CorporateTrainingType corporateTrainingType, Course course, LocalDate date, Trainer trainer, String materialPath) {
        this.id = id;
        this.corporateTrainingType = corporateTrainingType;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
        this.materialPath = materialPath;
    }

    public CorporateTraining(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CorporateTrainingType getCorporateTrainingType() {
        return corporateTrainingType;
    }

    public void setCorporateTrainingType(CorporateTrainingType corporateTrainingType) {
        this.corporateTrainingType = corporateTrainingType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getMaterialPath() {
        return materialPath;
    }

    public void setMaterialPath(String materialPath) {
        this.materialPath = materialPath;
    }
}

