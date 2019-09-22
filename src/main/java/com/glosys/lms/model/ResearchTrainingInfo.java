package com.glosys.lms.model;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.ResearchTrainingType;

import java.util.List;

public class ResearchTrainingInfo {

    private List<ResearchTrainingType> researchTrainingTypes;
    private List<Course> courses;

    public ResearchTrainingInfo(List<ResearchTrainingType> researchTrainingTypes, List<Course> courses) {
        this.researchTrainingTypes = researchTrainingTypes;
        this.courses = courses;
    }

    public List<ResearchTrainingType> getResearchTrainingTypes() {
        return researchTrainingTypes;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
