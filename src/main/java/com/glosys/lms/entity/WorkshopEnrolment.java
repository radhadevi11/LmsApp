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

    @ManyToOne
    @JoinColumn(name = "workshop_type_id")
    private WorkshopType workshopType;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public WorkshopEnrolment() {
    }

    public WorkshopEnrolment(Student student, WorkshopType workshopType, Course course) {
        this(null, student, workshopType, course);
    }

    public WorkshopEnrolment(Integer id, Student student, WorkshopType workshopType, Course course) {
        this.id = id;
        this.student = student;
        this.workshopType = workshopType;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public WorkshopType getWorkshopType() {
        return workshopType;
    }

    public void setWorkshopType(WorkshopType workshopType) {
        this.workshopType = workshopType;
    }
}
