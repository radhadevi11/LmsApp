package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity(name = "certificate")
public class Certificate implements TrainingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "certificate_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Certificate() {
    }

    public Certificate(String name, Course course, LocalDate date, Trainer trainer) {
        this(null, name, course, date, trainer);
    }

    public Certificate(Integer id, String name, Course course, LocalDate date, Trainer trainer) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
    }

    public Certificate(Integer id) {
        this.id = id;
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

    @Override
    public TrainingProgramTypeEnum getTrainingProgramType() {
        return TrainingProgramTypeEnum.CERTIFICATE;
    }

    @Override
    public String getDuration() {
        return "3 Months";
    }
}
