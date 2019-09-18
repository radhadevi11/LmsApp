package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inplant_training")
public class InplantTraining implements TrainingProgram{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inplant_training_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "inplant_training_type_id")
    private  InplantTrainingType inplantTrainingType;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "inplant_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    public InplantTraining() {
    }

    public InplantTraining(Integer id) {
        this.id = id;
    }

    public InplantTraining(InplantTrainingType inplantTrainingType, Course course, LocalDate date,
                           Trainer trainer) {
        this(null, inplantTrainingType, course, date, trainer);
    }

    public InplantTraining(Integer id, InplantTrainingType inplantTrainingType, Course course, LocalDate date,
                           Trainer trainer) {
        this.id = id;
        this.inplantTrainingType = inplantTrainingType;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InplantTrainingType getInplantTrainingType() {
        return inplantTrainingType;
    }

    public void setInplantTrainingType(InplantTrainingType inplantTrainingType) {
        this.inplantTrainingType = inplantTrainingType;
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

    @Override
    public LocalDate getStartDate() {
        return this.date;
    }
}
