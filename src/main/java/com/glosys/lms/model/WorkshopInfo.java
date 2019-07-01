package com.glosys.lms.model;

import com.glosys.lms.Course;
import com.glosys.lms.WorkshopType;

import java.util.List;

public class WorkshopInfo {
    private List<WorkshopType> workshopTypes;
    private List<Course> courses;

    public WorkshopInfo(List<WorkshopType> workshopTypes, List<Course> courses) {
        this.workshopTypes = workshopTypes;
        this.courses = courses;
    }

    public List<WorkshopType> getWorkshopTypes() {
        return workshopTypes;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
