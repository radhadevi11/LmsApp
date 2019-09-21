package com.glosys.lms.entity;

import javax.persistence.*;

@Table(name = "inplant_training_enrolment")
@Entity
public class InplantTrainingEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inplant_training_enrolment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "inplant_training_id")
    private InplantTraining inplantTraining;

    public InplantTrainingEnrolment() {
    }

    public InplantTrainingEnrolment(Student student, InplantTraining inplantTraining) {
        this(null, student, inplantTraining);
    }

    public InplantTrainingEnrolment(Integer id, Student student, InplantTraining inplantTraining) {
        this.id = id;
        this.student = student;
        this.inplantTraining = inplantTraining;
    }

    public InplantTrainingEnrolment(Integer id) {
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

    public InplantTraining getInplantTraining() {
        return inplantTraining;
    }

    public void setInplantTraining(InplantTraining inplantTraining) {
        this.inplantTraining = inplantTraining;
    }
}
