package com.glosys.lms.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseController2 {

    private static CourseService2 courseService2 ;
    @Autowired
    public CourseController2(CourseService2 courseService2) {
        this.courseService2 = courseService2;
    }

    public boolean isExistingCourse(String courseCode){ return courseService2.isExistingCourse(courseCode); }


}
