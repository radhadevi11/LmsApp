package com.glosys.lms.model;

import com.glosys.lms.Course;
import com.glosys.lms.ResearchTraining;

import java.util.List;

public class ResearchTrainingInfo {

    private List<ResearchTraining> researchTrainings;
    private List<Course> courses;

    public ResearchTrainingInfo(List<ResearchTraining> researchTrainings, List<Course> courses) {
        this.researchTrainings = researchTrainings;
        this.courses = courses;
    }

    public List<ResearchTraining> getResearchTrainings() {
        return researchTrainings;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
