package com.glosys.lms.entity;

import javax.persistence.*;

@Table(name = "research_training_course_enrolment")
@Entity
public class ResearchTrainingCourseEnrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "research_training_enrolment_id")
    private ResearchTrainingEnrolment researchTrainingEnrolment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public ResearchTrainingCourseEnrolment() {
    }

    public ResearchTrainingCourseEnrolment(ResearchTrainingEnrolment researchTrainingEnrolment, Course course) {
        this(null, researchTrainingEnrolment, course);
    }

    public ResearchTrainingCourseEnrolment(Integer id, ResearchTrainingEnrolment researchTrainingEnrolment, Course course) {
        this.id = id;
        this.researchTrainingEnrolment = researchTrainingEnrolment;
        this.course = course;
    }

    public ResearchTrainingCourseEnrolment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResearchTrainingEnrolment getResearchTrainingEnrolment() {
        return researchTrainingEnrolment;
    }

    public void setResearchTrainingEnrolment(ResearchTrainingEnrolment researchTrainingEnrolment) {
        this.researchTrainingEnrolment = researchTrainingEnrolment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
