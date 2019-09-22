package com.glosys.lms.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "research_training")
@Entity
public class ResearchTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_training_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "research_training_type_id")
    private  ResearchTrainingType ResearchTrainingType;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "start_date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    public ResearchTraining(com.glosys.lms.entity.ResearchTrainingType researchTrainingType,
                        Course course, LocalDate date, Trainer trainer) {
        this(null, researchTrainingType, course, date, trainer);
    }

    public ResearchTraining(Integer id) {
        this.id = id;
    }

    public ResearchTraining(Integer id, com.glosys.lms.entity.ResearchTrainingType researchTrainingType,
                            Course course, LocalDate date, Trainer trainer) {
        this.id = id;
        ResearchTrainingType = researchTrainingType;
        this.course = course;
        this.date = date;
        this.trainer = trainer;
    }

    public ResearchTraining() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.glosys.lms.entity.ResearchTrainingType getResearchTrainingType() {
        return ResearchTrainingType;
    }

    public void setResearchTrainingType(com.glosys.lms.entity.ResearchTrainingType researchTrainingType) {
        ResearchTrainingType = researchTrainingType;
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
}
