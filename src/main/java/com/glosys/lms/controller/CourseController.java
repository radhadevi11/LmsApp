package com.glosys.lms.controller;

import com.glosys.lms.Course;
import service.CourseService;

import java.util.List;

public class CourseController {
    private static CourseService courseService = new CourseService();

    public void saveCourse(Course course){
        courseService.saveCourse(course);
    }

    public boolean isExistingCourse(String courseCode){ return courseService.isExistingCourse(courseCode);}

    public List<Course> getAllCourse(){ return courseService.getAllCourse();}

    public Course getCourseByCourseId(Integer courseId){ return courseService.getCourseByCourseId(courseId);}

    public void updateCourseByCourseId(Integer courseId, Course course){
        courseService.updateCourseByCourseId(courseId, course);
    }
}
