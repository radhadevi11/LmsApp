package com.glosys.lms.model;

import com.glosys.lms.CorporateTrainingType;
import com.glosys.lms.Course;

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
