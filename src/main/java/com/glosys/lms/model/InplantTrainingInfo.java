package com.glosys.lms.model;

import com.glosys.lms.entity.Course;
import com.glosys.lms.entity.InplantTrainingType;

import java.util.List;

public class InplantTrainingInfo {
    private List<InplantTrainingType> inplantTrainingTypes;
    private List<Course> courses;

    public InplantTrainingInfo(List<InplantTrainingType> inplantTrainingTypes, List<Course> courses) {
        this.inplantTrainingTypes = inplantTrainingTypes;
        this.courses = courses;
    }

    public List<InplantTrainingType> getInplantTrainingTypes() {
        return inplantTrainingTypes;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
