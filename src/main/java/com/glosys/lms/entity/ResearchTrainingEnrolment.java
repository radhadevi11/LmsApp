package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name="research_training_enrolment")
public class ResearchTrainingEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_training_enrolment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "reserch_training_id")
    private ResearchTraining researchTraining;

    public ResearchTrainingEnrolment() {
    }

    public ResearchTrainingEnrolment(Student student, ResearchTraining researchTraining) {
        this(null, student, researchTraining);
    }

    public ResearchTrainingEnrolment(Integer id, Student student, ResearchTraining researchTraining) {
        this.id = id;
        this.student = student;
        this.researchTraining = researchTraining;
    }

    public ResearchTrainingEnrolment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ResearchTraining getResearchTraining() {
        return researchTraining;
    }

    public void setResearchTraining(ResearchTraining researchTraining) {
        this.researchTraining = researchTraining;
    }
}
