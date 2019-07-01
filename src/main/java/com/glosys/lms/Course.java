package com.glosys.lms;

import javax.persistence.*;

@Table(name = "course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "syllabus")
    private String syllabus;

    @Column(name = "course_category_id")
    private Integer courseCategoryId;

    @Column(name = "workshop_eligibility")
    private boolean workshopEligibility;

    @Column(name = "research_training_eligibility")
    private boolean researchTrainingEligibility;

    @Column(name = "inplant_training_eligibility")
    private boolean inplantTrainingEligibility;

    @Column(name = " corporate_training_eligibility")
    private boolean corporateTrainingEligibility;

    public Course() {

    }

    public Course(String name, String syllabus, Integer courseCategoryId, boolean workshopEligibility,
                  boolean researchTrainingEligibility, boolean inplantTrainingEligibility, boolean corporateTrainingEligibility) {
        this.name = name;
        this.syllabus = syllabus;
        this.courseCategoryId = courseCategoryId;
        this.workshopEligibility = workshopEligibility;
        this.researchTrainingEligibility = researchTrainingEligibility;
        this.inplantTrainingEligibility = inplantTrainingEligibility;
        this.corporateTrainingEligibility = corporateTrainingEligibility;
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

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public Integer getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Integer courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public boolean isWorkshopEligibility() {
        return workshopEligibility;
    }

    public void setWorkshopEligibility(boolean workshopEligibility) {
        this.workshopEligibility = workshopEligibility;
    }

    public boolean isResearchTrainingEligibility() {
        return researchTrainingEligibility;
    }

    public void setResearchTrainingEligibility(boolean researchTrainingEligibility) {
        this.researchTrainingEligibility = researchTrainingEligibility;
    }

    public boolean isInplantTrainingEligibility() {
        return inplantTrainingEligibility;
    }

    public void setInplantTrainingEligibility(boolean inplantTrainingEligibility) {
        this.inplantTrainingEligibility = inplantTrainingEligibility;
    }

    public boolean isCorporateTrainingEligibility() {
        return corporateTrainingEligibility;
    }

    public void setCorporateTrainingEligibility(boolean corporateTrainingEligibility) {
        this.corporateTrainingEligibility = corporateTrainingEligibility;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", courseCategoryId=" + courseCategoryId +
                ", workshopEligibility=" + workshopEligibility +
                ", researchTrainingEligibility=" + researchTrainingEligibility +
                ", inplantTrainingEligibility=" + inplantTrainingEligibility +
                ", corporateTrainingEligibility=" + corporateTrainingEligibility +
                '}';
    }
}
