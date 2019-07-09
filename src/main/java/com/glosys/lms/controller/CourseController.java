package com.glosys.lms.controller;

import com.glosys.lms.Course;
import service.CourseService;

public class CourseController {
    private static CourseService courseService = new CourseService();

    public void saveCourse(Course course){
        courseService.saveCourse(course);
    }

    public boolean isExistingCourse(String courseCode){ return courseService.isExistingCourse(courseCode);}
}
