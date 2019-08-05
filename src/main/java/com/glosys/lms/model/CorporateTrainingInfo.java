package com.glosys.lms.model;

import com.glosys.lms.entity.CorporateTrainingType;
import com.glosys.lms.entity.Course;

import java.util.List;

public class CorporateTrainingInfo {

    private List<CorporateTrainingType> corporateTrainingTypes;
    private List<Course> courses;

    public CorporateTrainingInfo(List<CorporateTrainingType> corporateTrainingTypes, List<Course> courses) {
        this.corporateTrainingTypes = corporateTrainingTypes;
        this.courses = courses;
    }

    public List<CorporateTrainingType> getCorporateTrainingTypes() {
        return corporateTrainingTypes;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
