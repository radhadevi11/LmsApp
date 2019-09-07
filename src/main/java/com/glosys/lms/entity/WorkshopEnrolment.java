package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "workshop_enrolment")
public class WorkshopEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_enrolment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;


    public WorkshopEnrolment() {
    }

    public WorkshopEnrolment(Student student, Workshop workshop) {
        this(null, student, workshop);
    }

    public WorkshopEnrolment(Integer id, Student student, Workshop workshop) {
        this.id = id;
        this.student = student;
        this.workshop = workshop;

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

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public String toString() {
        return "WorkshopEnrolment{" +
                "id=" + id +
                ", student=" + student +
                ", workshop=" + workshop +
                '}';
    }
}


